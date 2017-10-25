package com.tutorials.csvflat.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.tutorials.csvflat.bean.OrderBeanCsv;
import com.tutorials.csvflat.fixed.bean.OrderBeanFixed;

public class CSVtoFixedProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		OrderBeanCsv orderBean = exchange.getIn().getBody(OrderBeanCsv.class);
		OrderBeanFixed fixedOrderBean = new OrderBeanFixed();
		fixedOrderBean.setCustomerName(orderBean.getCustomerName());
		fixedOrderBean.setOrderId(orderBean.getOrderId());
		fixedOrderBean.setPincode(orderBean.getPincode());
		exchange.getIn().setBody(fixedOrderBean, OrderBeanFixed.class);
	}

}
