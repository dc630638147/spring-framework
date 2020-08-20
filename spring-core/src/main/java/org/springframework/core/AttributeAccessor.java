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

package org.springframework.core;

import org.springframework.lang.Nullable;

/**
 * 提供对beandefinition元数据操作的api
 * 元数据操作接口
 */
public interface AttributeAccessor {

	//设置元数据
	//最好使用全限定类名作为参数，否则容易被其他元数据覆盖
	void setAttribute(String name, @Nullable Object value);

	//设置元数据
	//最好使用全限定类名作为参数，否则容易被其他元数据覆盖
	@Nullable
	Object getAttribute(String name);

	//删除元数据
	@Nullable
	Object removeAttribute(String name);

	//是否含有元数据
	boolean hasAttribute(String name);

	//获取元数据的name数组
	String[] attributeNames();

}
