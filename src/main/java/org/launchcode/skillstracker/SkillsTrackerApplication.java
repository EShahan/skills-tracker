package org.launchcode.skillstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class SkillsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillsTrackerApplication.class, args);
	}

	@Controller
	@RequestMapping
	@ResponseBody
	public class SkillsTracker {

		public String Skills() {
			String html =
					"<html>" + "<body>" +
						"<h1>Skills Tracker</h1>" +
							"<h2>" + "<ol>" +
								"<li>Java</li>" +
								"<li>JavaScript</li>" +
								"<li>Python</li>" +
							"</ol>" + "</h2>" +
					"</body>" + "</html>";
			return html;
		}

		@GetMapping(value = "/form")
		@ResponseBody
		public String SkillsForm() {
			String html =
					"<html>" + "<body>" +
							"<form method = 'post' action = '/form'>" +
								"<label for=coder>Name</label>" + "<br/>" +
								"<input type = 'text' name = 'coder' />" + "<br/>" + "<br/>" +
								"<label for=LanguageOne>Language One</label>" + "<br/>" +
								"<select name = 'languageOne'>" +
									"<option value = 'Java'>Java</option>" +
									"<option value = 'JavaScript'>JavaScript</option>" +
									"<option value = 'Python'>Python</option>" +
								"</select>" + "<br/>" +
								"<label for=LanguageTwo>Language Two</label>" + "<br/>" +
								"<select name = 'languageTwo'>" +
									"<option value = 'Java'>Java</option>" +
									"<option value = 'JavaScript'>JavaScript</option>" +
									"<option value = 'Python'>Python</option>" +
								"</select>" + "<br/>" +
								"<label for=LanguageThree>Language Three</label>" + "<br/>" +
								"<select name = 'languageThree'>" +
									"<option value = 'Java'>Java</option>" +
									"<option value = 'JavaScript'>JavaScript</option>" +
									"<option value = 'Python'>Python</option>" +
								"</select>" + "<br/>" +
								"<input type = 'submit' value = 'Submit!' />" +
							"</form>" +
					"</body>" + "</html>";
			return html;
		}

		@PostMapping("/form")
		public String SkillsAnswer(@RequestParam String coder, @RequestParam String languageOne, @RequestParam String languageTwo, @RequestParam String languageThree) {
			String html =
					"<html>" + "<body>" +
							"<h1>" + coder + "</h1>" +
							"<h2>" + "<ol>" +
							"<li>" + languageOne + "</li>" +
							"<li>" + languageTwo + "</li>" +
							"<li>" + languageThree + "</li>" +
							"</ol>" + "</h2>" +
					"</body>" + "</html>";
			return html;
		}
	}
}
