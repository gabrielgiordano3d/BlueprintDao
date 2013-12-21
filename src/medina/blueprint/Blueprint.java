/* Copyright (C) 2013 Gabriel Giordano
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */
package medina.blueprint;

import medina.blueprint.util.StatementBuilder;

public abstract class Blueprint<E> extends Engine<E>
{
	
	protected final StatementBuilder<E> statementTool;
	
	public Blueprint(SessionManager session)
	{
		super(session);
		
		Class<?> defaultClass = EngineUtil.resolveGenericType(getClass());
		setDefaultEntity(defaultClass);
		
		statementTool = new StatementTool<E>(defaultClass) {};
		
		objectsSettings.setFillObjects(true);
		objectsSettings.setFillSubObjects(false);
		
		listsSettings.setFillLists(false);
		listsSettings.setFillSubLists(false);
	}
	
	public EntityObjectsSettings getObjectsSettings()
	{
		return objectsSettings;
	}
	
	public EntityListsSettings getListsSettings()
	{
		return listsSettings;
	}
	
	protected StatementBuilder<E> getStatementTool()
	{
		return statementTool;
	}
}
