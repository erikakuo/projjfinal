package acc.br.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import acc.br.projetofinal.model.LoginModel;
import acc.br.projetofinal.model.StudentModel;
import acc.br.projetofinal.service.LoginService;
import acc.br.projetofinal.service.StudentService;

@Controller
@RequestMapping("/studentRegistration")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private LoginService loginService;

	@GetMapping("/index")
	public String showIndexPage(Model model) {
		model.addAttribute("student", new StudentModel());
		model.addAttribute("student", StudentService.findAll());
		return "index";
	}

	@PostMapping
	    public String createStudent(@ModelAttribute StudentModel studentDTO) {
	        StudentModel studentModel = new StudentModel ();
	        
	        StudentModel.setName(studentService.getNome());
	        StudentModel.setCep(studentService..getCep());
	        StudentModel.setLocalidade(studentService..getLocalidade());
	        StudentModel.setnascimento(studentService..getnascimento());
	        StudentModel.setSubject(studentService..getSubject());

	        studentService.save(studentModel);
	        return 
	    }

	@GetMapping("/index/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		StudentModel student = studentService.getStudentById(id);
		if (student != null) {
			model.addAttribute("student", student);
			return "index";
		} else {
			return "redirect:/studentRegistration/index";
		}
	}

	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute StudentModel studentDTO) {
		StudentModel studentModel = studentService.getStudentById(id);
		if (studentModel != null) {
			// Atualiza os dados do aluno com o DTO
			studentModel.setName(studentDTO.getName());
			studentModel.setCep(studentDTO.getCep());
			studentModel.setLocalidade(studentDTO.getLocalidade());
			studentModel.setBirthDate(studentDTO.getBirthDate());
			studentModel.setSubject(studentDTO.getSubject());

			studentService.update(id, studentModel); // Chama o serviço para atualizar
		}
		return "redirect:/studentRegistration/index"; // Redireciona após a atualização
	}

	// Exclusão de um aluno
	@PostMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.delete(id); // Chama o serviço para excluir
		return "redirect:/studentRegistration/index"; // Redireciona após a exclusão
	}

	// Métodos de autenticação (Login)

	// Exibe a página de login
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	// Processa o login do usuário
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		LoginModel user = LoginService.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return "redirect:/studentRegistration/index"; // Redireciona para a página de alunos após login
		}
		model.addAttribute("error", "Invalid username or password");
		return "login"; // Exibe erro e permanece na página de login
	}

	// Exibe a página de registro do usuário
	@GetMapping("/login/register")
	public String showRegistrationPage() {
		return "register";
	}

	// Registra um novo usuário (Login)
	@PostMapping("/login/register")
	public String registerUser(@ModelAttribute LoginModel loginDTO) {
		// Registra um novo login (usuario)
		loginService.register(loginDTO);
		return "redirect:/studentRegistration/login"; // Redireciona para a página de login após o registro
	}
}