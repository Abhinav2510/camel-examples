package com.tutorials.csvflat.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.tutorials.csvflat.fixed.bean.OrderBenFixed;

public class CSVtoFixedProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// System.out.println("Body class" +
		// exchange.getIn().getBody().getClass());
		@SuppressWarnings("unchecked")
		List<OrderBean> list = (ArrayList<OrderBean>) exchange.getIn().getBody(ArrayList.class);
		
		List<Map<String, Object>> listOut = new ArrayList<Map<String, Object>>();

		for (OrderBean recordObject : list) {

			Map<String, Object> map = new HashMap();

			OrderBean orderben = recordObject;

			OrderBenFixed orderBenFixed = new OrderBenFixed();
			orderBenFixed.setOrderId(orderben.getOrderId());
			orderBenFixed.setCustomerName(orderben.getCustomerName());
			orderBenFixed.setPincode(orderben.getPincode());
			
			map.put(orderBenFixed.getClass().getName(), orderBenFixed);
			listOut.add(map);
			
		}
		
		exchange.getIn().setBody(listOut, ArrayList.class);
	}

}
