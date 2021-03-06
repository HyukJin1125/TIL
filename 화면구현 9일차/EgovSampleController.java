/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  ?????????      ?????????              ????????????
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           ????????????
 *
 * @author ????????????????????? ???????????? ?????????
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class EgovSampleController {

	/** EgovSampleService */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/test_ajax.do")
	public String test_ajax(HttpServletRequest request) {
		System.out.println("/test_ajax.do");
		
		String name = request.getParameter("name");
		String lecture = request.getParameter("lecture");
		System.out.println("name::::"+name+",    lecture::::"+lecture);
		
		return "sample/test_ajax00.html";
	}
	
	@RequestMapping(value="/fn_ajax00.do")
	public String fn_ajax00() {
		System.out.println("fn_ajax00");
		return "sample/test_ajax01.html";
	}
	@RequestMapping(value="/fn_ajax01.do")
	public String fn_ajax01(HttpServletRequest request) {
		System.out.println("fn_ajax01");
		String name = request.getParameter("name");
		String lecture = request.getParameter("lecture");
		System.out.println("name:: "+name);
		System.out.println("lecture:: "+lecture);
		return "sample/test_ajax01.html";
	}
	@RequestMapping(value="/fn_ajax02.do")
	public String fn_ajax02(HttpServletRequest request) {
		System.out.println("fn_ajax02");
		String name = request.getParameter("name");
		String lecture = request.getParameter("lecture");
		System.out.println("name:: "+name);
		System.out.println("lecture:: "+lecture);
		return "sample/test_ajax01.html";
	}
	@RequestMapping(value="/fn_ajax03.do")
	public String fn_ajax03(HttpServletRequest request) {
		System.out.println("fn_ajax03");
		String center_info = request.getParameter("center_info");	
		System.out.println("center_info: " + center_info);
		center_info = center_info.replaceAll("&quot;", "\"");
		System.out.println("center_info(2): " + center_info);
		JSONParser JSONParser = new JSONParser();
		
		try{
			JSONObject jsonObject = (JSONObject)JSONParser.parse(center_info);
			System.out.println("jsonObject:"+jsonObject);
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("lecture"));
			
			Iterator iterator= jsonObject.keySet().iterator();
	        while(iterator.hasNext()){
	           
				String key = iterator.next().toString(); // key ??????????????? ??????
				System.out.println("key:::"+key+", value::"+jsonObject.get(key));
	        }
		}catch (ParseException e) {
		e.printStackTrace();
		}
		return "sample/test_ajax01.html";
	}
	@RequestMapping(value="/fn_ajax03_1.do")
	public String fn_ajax03_1(@RequestBody Map<String, Object>map) {
		System.out.println("fn_ajax03_1");
		System.out.println("name: " + map.get("name"));
		System.out.println("lecture: " + map.get("lecture"));
		return "sample/test_ajax01.html";
	}
	@RequestMapping(value="/fn_ajax04.do")
	public String fn_ajax04(HttpServletRequest request) {
		System.out.println("fn_ajax04");
		String centerInfo_arr = request.getParameter("centerInfo_arr");
		System.out.println("centerInfo_arr: " + centerInfo_arr);
		centerInfo_arr = centerInfo_arr.replaceAll("&quot;", "\"");
		System.out.println("centerInfo_arr_replace: " + centerInfo_arr);
		JSONParser jsonParser = new JSONParser();
		try {
		JSONArray jsonArray = (JSONArray) jsonParser.parse(centerInfo_arr);
		System.out.println("jsonArray : " + jsonArray);
		System.out.println("jsonArray.size(): "+jsonArray.size());
		for(int i = 0; i < jsonArray.size(); i++) {
			System.out.println("????????? i: "+ i +" ???: " + jsonArray.get(i));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sample/test_ajax01.html";
	}

	  @RequestMapping(value="/fn_ajax04_1.do") public String
	  fn_ajax04_1(@RequestParam(name="centerArr[]",required =
	  false)List<String> centerArr) { System.out.println("fn_ajax04_1");
	  System.out.println(centerArr);
	  System.out.println("centerArr.size():"+centerArr.size());
	  
	  for(int i=0; i < centerArr.size();i++) { System.out.println("????????? i : "+ i+
	  "???: "+centerArr.get(i)); } return "sample/test_ajax01.html"; }
	 
	
	@RequestMapping(value="fn_ajax05.do")
	public String fn_ajax05() {
		System.out.println("fn_ajax05");
		return "sample/test_ajax01.html";
	}
	
	
	@RequestMapping(value="/test_map01.do")
	 public String test_map01() {
	 System.out.println("/test_map01.do");
     return "sample/test_map01.html";  

	   }
	
	/**
	 * ??? ????????? ????????????. (pageing)
	 * @param searchVO - ????????? ????????? ?????? SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	  @RequestMapping(value = "/login.do")
	  public String login() {
     System.out.println("/login.do");
     return "sample/login.html";
   } 

	
	  @RequestMapping(value = "/test_ajax01.do") public String test_ajax01() {
	  System.out.println("/test_ajax01.do"); return "sample/test_ajax01.html"; }
	 
	
	 /* @RequestMapping(value = "/fn_ajax01.do") public String
	  fn_ajax01(HttpServletRequest request) { System.out.println("/fn_ajax01.do");
	  String name = request.getParameter("name"); String lecture =
	  request.getParameter("lecture");
	  System.out.println("name::::"+name+",    lecture::::"+lecture); return
	  "sample/test_ajax01.html"; }
	 */
	@RequestMapping(value = "/egovSampleList.do")
	public String selectSampleList(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> sampleList = sampleService.selectSampleList(searchVO);
		model.addAttribute("resultList", sampleList);

		int totCnt = sampleService.selectSampleListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "sample/egovSampleList";
	}

	/**
	 * ??? ?????? ????????? ????????????.
	 * @param searchVO - ?????? ???????????? ????????? ?????? VO
	 * @param model
	 * @return "egovSampleRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addSample.do", method = RequestMethod.GET)
	public String addSampleView(@ModelAttribute("searchVO") SampleDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("sampleVO", new SampleVO());
		return "sample/egovSampleRegister";
	}

	/**
	 * ?????? ????????????.
	 * @param sampleVO - ????????? ????????? ?????? VO
	 * @param searchVO - ?????? ???????????? ????????? ?????? VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addSample.do", method = RequestMethod.POST)
	public String addSample(@ModelAttribute("searchVO") SampleDefaultVO searchVO, SampleVO sampleVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(sampleVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("sampleVO", sampleVO);
			return "sample/egovSampleRegister";
		}

		sampleService.insertSample(sampleVO);
		status.setComplete();
		return "forward:/egovSampleList.do";
	}

	/**
	 * ??? ??????????????? ????????????.
	 * @param id - ????????? ??? id
	 * @param searchVO - ?????? ???????????? ????????? ?????? VO
	 * @param model
	 * @return "egovSampleRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateSampleView.do")
	public String updateSampleView(@RequestParam("selectedId") String id, @ModelAttribute("searchVO") SampleDefaultVO searchVO, Model model) throws Exception {
		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(id);
		// ???????????? CoC ??? ?????? sampleVO
		model.addAttribute(selectSample(sampleVO, searchVO));
		return "sample/egovSampleRegister";
	}

	/**
	 * ?????? ????????????.
	 * @param sampleVO - ????????? ????????? ?????? VO
	 * @param searchVO - ?????? ???????????? ????????? ?????? VO
	 * @param status
	 * @return @ModelAttribute("sampleVO") - ????????? ??????
	 * @exception Exception
	 */
	public SampleVO selectSample(SampleVO sampleVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO) throws Exception {
		return sampleService.selectSample(sampleVO);
	}

	/**
	 * ?????? ????????????.
	 * @param sampleVO - ????????? ????????? ?????? VO
	 * @param searchVO - ?????? ???????????? ????????? ?????? VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping("/updateSample.do")
	public String updateSample(@ModelAttribute("searchVO") SampleDefaultVO searchVO, SampleVO sampleVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(sampleVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("sampleVO", sampleVO);
			return "sample/egovSampleRegister";
		}

		sampleService.updateSample(sampleVO);
		status.setComplete();
		return "forward:/egovSampleList.do";
	}

	/**
	 * ?????? ????????????.
	 * @param sampleVO - ????????? ????????? ?????? VO
	 * @param searchVO - ?????? ???????????? ????????? ?????? VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deleteSample.do")
	public String deleteSample(SampleVO sampleVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO, SessionStatus status) throws Exception {
		sampleService.deleteSample(sampleVO);
		status.setComplete();
		return "forward:/egovSampleList.do";
	}

}
