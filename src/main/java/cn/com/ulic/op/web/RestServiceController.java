package cn.com.ulic.op.web;

import cn.com.ulic.op.EnvConfig;
import cn.com.ulic.op.domain.Code;
import cn.com.ulic.op.http.HttpAPIService;
import cn.com.ulic.op.service.CommonService;
import cn.com.ulic.op.service.LogService;
import cn.com.ulic.op.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ruanhua on 2017/6/6.
 */
@RestController
public class RestServiceController {

    @Autowired
    private EnvConfig envConfig;

    @Autowired
    private HttpAPIService httpAPIService;

    @Autowired
    private LogService logService;

    @Autowired
    private CommonService commonService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/queryCode", method = RequestMethod.POST)
    public List<Code> queryCode(@RequestBody Condition condition) {
        List<Code> codes = commonService.getCodes(condition);
        return codes;
    }

}
