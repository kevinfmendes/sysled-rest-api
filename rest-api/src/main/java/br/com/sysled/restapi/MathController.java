package br.com.sysled.restapi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping(value = "/sum/{numOne}/{numTwo}")
	public Double sum (
			@PathVariable(value = "numOne")String numOne,
			@PathVariable(value = "numTwo")String numTwo
			) throws Exception {
				if (!isNumeric(numOne) || !isNumeric(numTwo)){
					throw new Exception();
				}
				return convertToDouble(numOne) + convertToDouble(numTwo);
			}
	
	private Double convertToDouble(String strNum) {
		
		if (strNum == null) return 0D;
		
		String number = strNum.replaceAll(",", ".");
		
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
		
	}

	private boolean isNumeric(String strNum) {
		
		if (strNum == null) return false;
		String number = strNum.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}
}
