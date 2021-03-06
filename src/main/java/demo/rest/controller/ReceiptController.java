package demo.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.rest.data.Receipt;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Receipt getReceipt(@PathVariable long id) {
		return new Receipt();
	}

}
