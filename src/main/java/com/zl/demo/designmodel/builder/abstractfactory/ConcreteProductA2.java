/**
 * 
 */
package com.zl.demo.designmodel.builder.abstractfactory;

/**
 * @author Qiuman
 *
 */
public class ConcreteProductA2 implements IProductA {

	@Override
	public void operation() {
		System.out.println(this.getClass().getSimpleName());
	}

}
