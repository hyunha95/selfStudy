package com.kh.spring.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		Foo foo = new FooProxy(new FooImpl(), new Aspect());
		System.out.println(foo.getName());
	}

}
class Aspect {
	public void before() {
		System.out.println("before");
	}
	public void after() {
		System.out.println("after");
	}
	
}
class FooProxy implements Foo {

	Foo target;
	Aspect aspect;
	
	public FooProxy(Foo target, Aspect aspect) {
		this.target = target;
		this.aspect = aspect;
	}
	
	@Override
	public String getName() {
		aspect.before();
		String name = target.getName();
		aspect.after();
		return name;
	}
	
}

interface Foo {
	String getName();
}

class FooImpl implements Foo {

	@Override
	public String getName() {
		System.out.println("getName 실행");
		return "Hong Gildong";
	}
	
}