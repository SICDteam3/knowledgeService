package org.xjtusicd3.portal.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.portal.service.SystemStateService;
@RequestMapping(value="state")
@Controller
public class SystemStateController {
	
	@RequestMapping(value="toPatentUpdate",method=RequestMethod.GET)
	public ModelAndView toPatentUpdate(){
		ModelAndView mv=new ModelAndView("systemstate/patentupdate");
		
	
		return mv;
	}
	@RequestMapping(value="tologinCount",method=RequestMethod.GET)
	public ModelAndView tologinCount(){
		ModelAndView mv=new ModelAndView("systemstate/onlineusers");
		
	
		return mv;
	}
	/*
	 * 专利变化柱状图参数
	 * @time 是前台传的时间段参数需要是1,2，或者3
	 * @return 一个包含变化数量的整数数组
	 * */
	@RequestMapping(value="patentUpdateState",method=RequestMethod.GET)
	public ModelAndView patentUpdateState(int time){
		ModelAndView mv=new ModelAndView("systemstate/patentupdate");
		SystemStateService ss=new SystemStateService();
		String i = null;
		if(time==1){
			i="'周一', '周二', '周三', '周四', '周五', '周六', '周日'";
		}
		else if(time==2){
			i="'第一周', '第二周', '第三周', '第四周'";
		}
		else{
			i="'第一月', '第二月', '第三月', '第四月', '第五月', '第六月'";
		}
		mv.addObject("time1",i);
		String num=ss.patentUpdateCount(time);
		mv.addObject("puc",num);
		return mv;
	}
	/*
	 * 在线人数变化
	 * */
	@RequestMapping(value="loginCount",method=RequestMethod.GET)
	public ModelAndView loginCount(int time){
		ModelAndView mv=new ModelAndView("systemstate/onlineusers");
		SystemStateService ss=new SystemStateService();
		String num=ss.loginCount(time);
		String i = null;
		if(time==1){
			i="'1点', '2点', '3点', '4点', '5点', '6点', '7点','8点'，'9点', '10点', '11点', '12点', '13点', '14点', '15点','16点'"
					+ "'17点','18点', '19点', '20点', '21点', '22点', '23点', '24点'";
		}
		else if(time==2){
			i="'第一天', '第二天', '第三天', '第四天', '第五天', '第六天', '第七天'";
		}
		mv.addObject("time", i);
		mv.addObject("lc",num);
		return mv;
	}
	
	
}
