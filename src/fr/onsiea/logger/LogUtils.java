/**
*	Copyright 2021 Onsiea All rights reserved.
*
*	This file is part of OnsieaLogger. (https://github.com/Onsiea/OnsieaLogger)
*
*	Unless noted in license (https://github.com/Onsiea/OnsieaLogger/blob/main/LICENSE.md) notice file (https://github.com/Onsiea/OnsieaLogger/blob/main/LICENSE_NOTICE.md), OnsieaLogger and all parts herein is licensed under the terms of the LGPL-3.0 (https://www.gnu.org/licenses/lgpl-3.0.html)  found here https://www.gnu.org/licenses/lgpl-3.0.html and copied below the license file.
*
*	OnsieaLogger is libre software: you can redistribute it and/or modify
*	it under the terms of the GNU Lesser General Public License as published by
*	the Free Software Foundation, either version 3.0 of the License, or
*	(at your option) any later version.
*
*	OnsieaLogger is distributed in the hope that it will be useful,
*	but WITHOUT ANY WARRANTY; without even the implied warranty of
*	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*	GNU Lesser General Public License for more details.
*
*	You should have received a copy of the GNU Lesser General Public License
*	along with OnsieaLogger.  If not, see <https://www.gnu.org/licenses/> <https://www.gnu.org/licenses/lgpl-3.0.html>.
*
*	Neither the name "Onsiea", "OnsieaLogger", or any derivative name or the names of its authors / contributors may be used to endorse or promote products derived from this software and even less to name another project or other work without clear and precise permissions written in advance.
*
*	(more details on https://github.com/Onsiea/OnsieaLogger/wiki/License)
*
*	@author Seynax
*/
package fr.onsiea.logger;

import java.io.PrintStream;

/**
 * @author Seynax
 *
 */
public class LogUtils
{
	public final static String toString(Object... objectsIn)
	{
		final var content = new StringBuilder();

		for (final Object object : objectsIn)
		{
			content.append(object.toString());
		}

		return content.toString();
	}

	public final static void log(Object... objectsIn)
	{
		System.out.print(LogUtils.toString(objectsIn));
	}

	public final static void logLn(Object... objectsIn)
	{
		System.out.println(LogUtils.toString(objectsIn));
	}

	public final static void logErr(Object... objectsIn)
	{
		System.err.print(LogUtils.toString(objectsIn));
	}

	public final static void logErrLn(Object... objectsIn)
	{
		System.err.println(LogUtils.toString(objectsIn));
	}

	public final static void logIn(PrintStream printStreamIn, Object... objectsIn)
	{
		printStreamIn.print(LogUtils.toString(objectsIn));
	}

	public final static void logInLn(PrintStream printStreamIn, Object... objectsIn)
	{
		printStreamIn.println(LogUtils.toString(objectsIn));
	}
}