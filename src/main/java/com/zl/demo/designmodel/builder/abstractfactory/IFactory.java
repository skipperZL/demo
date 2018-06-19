/**
 * 
 */
package com.zl.demo.designmodel.builder.abstractfactory;

/**
 * @author Qiuman
 *
 */
public interface IFactory {
	
	IProductA createProductA();
	
	IProductB createProductB();
}
