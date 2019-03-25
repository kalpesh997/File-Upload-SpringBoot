package com.example.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController 
{
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	@RequestMapping("/")
	public String home() 
	{
		return "home.jsp";
	}
	
	@PostMapping("/upload")
	public String upload(Model model,@RequestParam("file") MultipartFile[] file) 
	{
		StringBuilder fname = new StringBuilder();
		for(MultipartFile f : file)
		{
			Path fileNamePath = Paths.get(uploadDirectory,f.getOriginalFilename());
			fname.append(f.getOriginalFilename());
			try 
			{
				Files.write(fileNamePath, f.getBytes());
			} 
			catch (Exception e) 
			{				
				e.printStackTrace();
			}
		}
		
		model.addAttribute("msg","successfully upload"+fname.toString());		
		return "home.jsp";
	}
}
