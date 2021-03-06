package in.co.rays.project0.ctl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.project0.dto.CourseDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.form.CourseForm;
import in.co.rays.project0.service.CourseServiceInt;

@Controller
@RequestMapping(value="/ctl/Course")
public class CourseCtl extends BaseCtl
{
   @Autowired
	private CourseServiceInt service;
   
   @Autowired
   private MessageSource messageSource;
   @InitBinder
   public void initBinder ( WebDataBinder binder )
   {
       StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
       binder.registerCustomEditor(String.class, stringtrimmer);
   }
   @Override
	public void preload(Model model) 
	{
	 List list1 = service.search(null);
	 model.addAttribute("courseList", list1);
	}   
   
   @ModelAttribute("durationList")
   public Map<String, String> getDurationList(Model model)
   {
	   Map<String, String> durationList = new LinkedHashMap<String, String>();
	   
	   durationList.put("1 Year", "1 Year");
	   durationList.put("2 Years", "2 Years");
	   durationList.put("3 Years", "3 Years");
	   durationList.put("4 Years", "4 Years");
	   durationList.put("5 Years", "5 Years");
	   
	return durationList;
   }
   
   
   @RequestMapping(value="/AddCourse" , method=RequestMethod.GET)
   public String display(@RequestParam(required=false) Long id , @ModelAttribute("form") CourseForm form,BindingResult result,Model model,Locale locale)
   {
	   String entername=messageSource.getMessage("label.entercoursename",null,locale);
		model.addAttribute("enterName",entername);
		
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
	   
	   if(id!=null && id>0)
	   {
		   CourseDTO dto = service.findById(id);
		   form.populate(dto);
	   }
	   
	return "CourseView";
   }
   
   @RequestMapping(value="/AddCourse" , method=RequestMethod.POST)
   public String submit(@ModelAttribute("form") @Valid CourseForm form,BindingResult result,Model model,Locale locale) throws DuplicateRecordException
   {
	   String entername=messageSource.getMessage("label.entercoursename",null,locale);
		model.addAttribute("enterName",entername);
		
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
	   
	   if(OP_SAVE.equalsIgnoreCase(form.getOperation()))
	   {
		   if(result.hasErrors())
		   {
			   return "CourseView";
		   }
		   
		   CourseDTO dto = (CourseDTO) form.getDto();
		   dto.setCreatedBy("root");
		   dto.setModifiedBy("root");
		   
		   if(dto.getId()>0)
		   {
			   service.update(dto);
			   String msg = messageSource.getMessage("message.updatesuccess", null, locale);
			   model.addAttribute("success",msg);
		   }else
		   {
			   try 
			   {
				  service.add(dto);
				  String msg = messageSource.getMessage("message.success", null, locale);
			      model.addAttribute("success",msg);
			   } catch (DuplicateRecordException e) 
			   {
				   String msg = messageSource.getMessage("error.coursename", null, locale);
				   model.addAttribute("error",msg);
			   }   
		   }
	   }
	   
	   if(OP_RESET.equalsIgnoreCase(form.getOperation()))
	   {
		   return "redirect:/ctl/Course/AddCourse";
	   }
	   if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
	   {
		   return "redirect:/ctl/Course/CourseListCtl";
	   }
	   
	return "CourseView";
   }
 
   @RequestMapping(value="/CourseListCtl" , method=RequestMethod.GET)
   public String display(@ModelAttribute("form") CourseForm form , Model model,Locale locale)
   {
	   String entername=messageSource.getMessage("label.entercoursename",null,locale);
		model.addAttribute("enterName",entername);
		
		int pageNo = 1;
		int pageSize = form.getPageSize();
		
		List list = service.search(new CourseDTO(), pageNo, pageSize);
		model.addAttribute("list", list);
		List next = service.search(new CourseDTO(), pageNo, pageSize);
		model.addAttribute("nextlistsize",next.size());
	   
	return "CourseListView";
   }
   
   @RequestMapping(value="/CourseListCtl" , method=RequestMethod.POST)
   public String submit(@RequestParam(required=false) String operation , @ModelAttribute("form") CourseForm form , Model model , Locale locale)
   {
	   String entername=messageSource.getMessage("label.entercoursename",null,locale);
		model.addAttribute("enterName",entername);
		
		int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
		int pageSize = form.getPageSize();
		
		List list = null;
		List next = null;
	   
		CourseDTO dto = (CourseDTO)form.getDto();
		
		if(OP_SEARCH.equalsIgnoreCase(operation))
		{
			pageNo=1;
		}
		if(OP_NEXT.equalsIgnoreCase(operation))
		{
			pageNo++;
		}
		if(OP_PREVIOUS.equalsIgnoreCase(operation))
		{
			pageNo--;
		}
		if(OP_DELETE.equalsIgnoreCase(operation))
		{
		   if(form.getChk_1() != null)
		   {
			   for(Long id : form.getChk_1())
			   {
				  service.delete(id);
			   }
			   String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
		   }else
		   {
			   String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
		   }
		}
		if(OP_RESET.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/Course/CourseListCtl";
		}
		if(OP_NEW.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/Course/AddCourse";
		}
		
		form.setPageNo(pageNo);
		
		list = service.search(dto, pageNo, pageSize);
		model.addAttribute("list", list);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation))
		{
		  model.addAttribute("error",messageSource.getMessage("message.norecord", null, locale));	
		}
		
		next = service.search(dto, pageNo+1, pageSize);
		model.addAttribute("nextlistsize", next.size());
		
		
	return "CourseListView";
   }
   
}

