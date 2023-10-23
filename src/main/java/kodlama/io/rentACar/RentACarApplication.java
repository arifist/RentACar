package kodlama.io.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exception.BusinessException;
import kodlama.io.rentACar.core.utilities.exception.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exception.ValidationProblemDetails;


@SpringBootApplication
@RestControllerAdvice //aopdir exceptionhandlera bagli
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@ExceptionHandler //hatalar  burdan gecer
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler //hatalar  burdan gecer
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		for(FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}
	
	//bean sayesinde bu newlemeyi ıoc'ye ekler ihyitac halinde kullanir.
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
