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

import fr.onsiea.logger.utils.LogUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Seynax
 *
 */

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PRIVATE)
public class StreamLogger implements ILogger
{
	private PrintStream	out;
	private PrintStream	err;

	public StreamLogger(PrintStream outIn, PrintStream errIn)
	{
		this.out(outIn);
		this.err(errIn);
	}

	@Override
	public ILogger log(EnumSeverity severityIn, Object... objectsIn)
	{
		final var content = "[" + severityIn.alias() + "]" + LogUtils.toString(objectsIn);

		if (severityIn.errStream())
		{
			this.err().print(content);
		}
		else
		{
			this.out().print(content);
		}

		return this;
	}

	@Override
	public ILogger logLn(EnumSeverity severityIn, Object... objectsIn)
	{
		final var content = "[" + severityIn.alias() + "]" + LogUtils.toString(objectsIn);
		if (severityIn.errStream())
		{
			this.err().println(content);
		}
		else
		{
			this.out().println(content);
		}

		return this;
	}

	@Override
	public ILogger log(Object... objectsIn)
	{
		this.out().print(LogUtils.toString(objectsIn));

		return this;
	}

	@Override
	public ILogger logLn(Object... objectsIn)
	{
		this.out().println(LogUtils.toString(objectsIn));

		return this;
	}

	@Override
	public ILogger logErr(Object... objectsIn)
	{
		this.err().print(LogUtils.toString(objectsIn));

		return this;
	}

	@Override
	public ILogger logErrLn(Object... objectsIn)
	{
		this.err().println(LogUtils.toString(objectsIn));

		return this;
	}
}