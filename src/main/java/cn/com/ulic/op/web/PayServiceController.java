package cn.com.ulic.op.web;

import cn.com.ulic.op.EnvConfig;
import cn.com.ulic.op.domain.*;
import cn.com.ulic.op.http.HttpAPIService;
import cn.com.ulic.op.http.HttpResult;
import cn.com.ulic.op.service.*;
import cn.com.ulic.op.util.ConstantUtil;
import cn.com.ulic.op.util.DateUtil;
import cn.com.ulic.op.util.InsuredNumUtil;
import cn.com.ulic.op.util.MyException;
import cn.com.ulic.op.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ruanhua
 */
@Controller
public class PayServiceController {

    @Autowired
    private PayLogService payLogService;

    @Autowired
    private PayCaseService payCaseService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpAPIService httpAPIService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CommonService commonService;

    @Resource
    private EnvConfig envConfig;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 接收支付信息
     * @param
     * @return
     */
    @RequestMapping(value="/payInput")
    public String getPayCase(HttpServletRequest request, ModelMap map) {
        List<Menu> menus = menuService.getFrontendMenus();
        map.addAttribute("menus", menus);
        PayCase payCase = new PayCase();
        PayReceiver payReceiver = new PayReceiver();
        map.put("payCase",payCase);
        map.put("payReceiver",payReceiver);
        return "payService/payInput";
    }

    /**
     * 初始化支付信息
     * @param
     * @return
     */
    @RequestMapping(value="/initPayInput/{payCaseNo}/{operateStyle}")
    public String initPayInput(HttpServletRequest request, @PathVariable("payCaseNo") String payCaseNo, @PathVariable("operateStyle") String operateStyle,ModelMap map) {
        List<Menu> menus = menuService.getFrontendMenus();
        map.addAttribute("menus", menus);
        PayCase payCase = payCaseService.getPayCase(payCaseNo);
        PayReceiver payReceiver = payCaseService.getPayReceiver(payCaseNo);
        if(payReceiver == null){
            payReceiver = new PayReceiver();
        }
        map.put("payCase",payCase);
        map.put("payReceiver",payReceiver);
        map.put("operateStyle",operateStyle);
        return "payService/payInput";
    }

    /**
     * 保存支付信息
     * @param
     * @return
     */
    @RequestMapping(value="/addPayCase",method = RequestMethod.POST)
    public void addPayCase(HttpServletRequest request, HttpServletResponse response,PayCase payCase, PayReceiver payReceiver,String operateStyle, ModelMap map) {
        if(payCase.getPayCaseNo() == null || "".equals(payCase.getPayCaseNo())){
            payCase.setPayCaseNo(InsuredNumUtil.getPayCaseNo(payCase.getRiskCode()));
        }
        payCase = payCaseService.savePayCase(payCase);
        payReceiver.setPayCaseNo(payCase.getPayCaseNo());
        payReceiver = payCaseService.savePayReceiver(payReceiver);
        map.put("payCase",payCase);
        map.put("payReceiver",payReceiver);
        try {
            response.sendRedirect("initPayInput/"+payCase.getPayCaseNo()+"/"+operateStyle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交支付信息
     * @param
     * @return
     */
    @RequestMapping(value="/submitPayCase",method = RequestMethod.POST)
    public void submitPayCase(HttpServletResponse response,PayCase payCase, PayReceiver payReceiver) {
        PaymentMain paymentMain = paymentService.getPaymentMainByPayCase(payCase,payReceiver);
        try {
            HttpResult result = httpAPIService.doPostString(envConfig.getSendPaymentURL(),JSON.toJSONString(paymentMain),ContentType.APPLICATION_JSON.getMimeType());
            if(result.getCode().intValue() != HttpStatus.SC_OK){
                throw  new MyException("调用支付接口异常");
            }
            RtnResult rtnResult = JSON.parseObject(result.getBody(),RtnResult.class);
            if(rtnResult == null || !ConstantUtil.PayDetailRetCode.SUCCESS.equals(rtnResult.getRet_code())){
                throw  new MyException("调用支付接口异常");
            }
            payCase.setPayStatus("WAIT");
            payCaseService.savePayCase(payCase);
            response.sendRedirect("success");
        } catch (Exception e) {
            e.printStackTrace();
            payCase.setPayStatus("FAIL");
            payCaseService.savePayCase(payCase);
        }
    }

    @RequestMapping("/payQuery")
    public String getPayQueryResult(HttpServletRequest request, PayQueryCondition payQueryCondition , ModelMap map){
        List<Menu> menus = menuService.getFrontendMenus();
        map.addAttribute("menus", menus);
        if (null == payQueryCondition.getPageNo()) {
            payQueryCondition.setPageNo("1");
        }
        PageHelper.startPage(Integer.valueOf(payQueryCondition.getPageNo()), 10);
        List<PayQueryResult> payQueryResults = payCaseService.findPayQueryResults(payQueryCondition);
        PageInfo pageInfo = new PageInfo(payQueryResults);
        Page page = (Page) payQueryResults;
        map.addAttribute("page",pageInfo);
        map.addAttribute("list",page);
        map.addAttribute("payQueryResults", payQueryResults);
        map.addAttribute("payQueryCondition", payQueryCondition);
        return "payService/payQuery";
    }

}
