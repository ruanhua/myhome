//menu
$(document).ready(function(){
  
  $('li.mainleve').mousemove(function(){
  $(this).find('ul').slideDown();//you can give it a speed
  });
  $('li.mainleve').mouseleave(function(){
  $(this).find('ul').slideUp("fast");
  });
  $('#sub_01').click(function(){
	  $('#backgroundImage').remove();
  });
});