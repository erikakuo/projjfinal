package acc.br.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.br.projetofinal.model.StudentModel;
import acc.br.projetofinal.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public StudentModel save(Student student) {
		return studentRepository.save(student);
	}

	public StudentModel update(Long id, Student student) {

		student.setNome(student.getNome());
		student.setCurso(student.getCurso());
		student.setCep(student.getCep());
		student.setDataNascimento(student.getDataNascimento());
		student.setLocalidade(student.getLocalidade());
		return studentRepository.save(student);

	}

	public List<StudentRepository> findAll() {
		return studentRepository.findAll();
	}

	public StudentRepository getstudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}