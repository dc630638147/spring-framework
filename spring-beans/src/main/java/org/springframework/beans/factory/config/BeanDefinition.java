/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.AttributeAccessor;
import org.springframework.lang.Nullable;

/**
 *  用于描述一个具体bean实例
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	/**
	 * scope值，单例
	 */
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	/**
	 * scope值，原型(多例)
	 */
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

	/**
	 * bean角色
	 */
	//用户
	int ROLE_APPLICATION = 0;
	//某些复杂的配置
	int ROLE_SUPPORT = 1;

	//完全内部使用
	int ROLE_INFRASTRUCTURE = 2;


	/**
	 * 设置父bd
	 * @param parentName
	 */
	void setParentName(@Nullable String parentName);

	/**
	 * 返回此bean定义的父bean定义的名称，如果有的话<bean parent="">
	 * @return
	 */
	@Nullable
	String getParentName();

	/**
	 * 设置bean的类型-名字-string
	 * setBeanClass-class
	 * <bean class="">
	 */
	void setBeanClassName(@Nullable String beanClassName);

	@Nullable
	String getBeanClassName();


	/**
	 * <bean scope="singleton/prototype"></>
	 * @param scope
	 */
	void setScope(@Nullable String scope);

	@Nullable
	String getScope();

	/**
	 * 懒加载 <bean lazy-init="true/false"></>
	 * @param lazyInit
	 */
	void setLazyInit(boolean lazyInit);
	boolean isLazyInit();

	/**
	 * 依赖对象 <bean depends-on=""></>
	 * @param dependsOn
	 */
	void setDependsOn(@Nullable String... dependsOn);
	@Nullable
	String[] getDependsOn();

	/**
	 * 是否为被自动装配 <bean autowire-candidate="true/false"></bean>
	 * @param autowireCandidate
	 */
	void setAutowireCandidate(boolean autowireCandidate);
	boolean isAutowireCandidate();

	/**
	 * 是否为主选bean  注解：@Primary
	 * @param primary
	 */
	void setPrimary(boolean primary);
	boolean isPrimary();

	/**
	 * 定义创建该bean的工厂类 <bean factory-bean=""></>
	 * @param factoryBeanName
	 */
	void setFactoryBeanName(@Nullable String factoryBeanName);
	@Nullable
	String getFactoryBeanName();

	/**
	 * 定义创建该bean对象的工厂方法 <bean factory-method></>
	 * @param factoryMethodName
	 */
	void setFactoryMethodName(@Nullable String factoryMethodName);
	@Nullable
	String getFactoryMethodName();

	/**
	 * Return the constructor argument values for this bean.
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the ConstructorArgumentValues object (never {@code null})
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/**
	 * Return if there are constructor argument values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}

	/**
	 * 获取普通属性集合
	 * @return
	 */
	MutablePropertyValues getPropertyValues();

	/**
	 * Return if there are property values values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasPropertyValues() {
		return !getPropertyValues().isEmpty();
	}

	/**
	 * Set the name of the initializer method.
	 * @since 5.1
	 */
	void setInitMethodName(@Nullable String initMethodName);

	/**
	 * Return the name of the initializer method.
	 * @since 5.1
	 */
	@Nullable
	String getInitMethodName();

	/**
	 * Set the name of the destroy method.
	 * @since 5.1
	 */
	void setDestroyMethodName(@Nullable String destroyMethodName);

	/**
	 * Return the name of the destroy method.
	 * @since 5.1
	 */
	@Nullable
	String getDestroyMethodName();

	/**
	 * Set the role hint for this {@code BeanDefinition}. The role hint
	 * provides the frameworks as well as tools with an indication of
	 * the role and importance of a particular {@code BeanDefinition}.
	 * @since 5.1
	 * @see #ROLE_APPLICATION
	 * @see #ROLE_SUPPORT
	 * @see #ROLE_INFRASTRUCTURE
	 */
	void setRole(int role);

	/**
	 * Get the role hint for this {@code BeanDefinition}. The role hint
	 * provides the frameworks as well as tools with an indication of
	 * the role and importance of a particular {@code BeanDefinition}.
	 * @see #ROLE_APPLICATION
	 * @see #ROLE_SUPPORT
	 * @see #ROLE_INFRASTRUCTURE
	 */
	int getRole();

	/**
	 * Set a human-readable description of this bean definition.
	 * @since 5.1
	 */
	void setDescription(@Nullable String description);

	/**
	 * 返回对bean定义的可读描述
	 * @return
	 */
	@Nullable
	String getDescription();


	// Read-only attributes

	/**
	 * 是否为单例
	 * @return
	 */
	boolean isSingleton();

	/**
	 * 是否为原型
	 * @return
	 */
	boolean isPrototype();

	/**
	 * 是否为抽象类
	 * @return
	 */
	boolean isAbstract();

	/**
	 * 返回该bean定义来自资源的描述(用于在出现错误时显示上下文)
	 * @return
	 */
	@Nullable
	String getResourceDescription();

	/**
	 * Return the originating BeanDefinition, or {@code null} if none.
	 * Allows for retrieving the decorated bean definition, if any.
	 * <p>Note that this method returns the immediate originator. Iterate through the
	 * originator chain to find the original BeanDefinition as defined by the user.
	 */
	@Nullable
	BeanDefinition getOriginatingBeanDefinition();

}
