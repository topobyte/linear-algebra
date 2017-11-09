// Copyright 2017 Sebastian Kuerten
//
// This file is part of linear-algebra.
//
// linear-algebra is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// linear-algebra is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with linear-algebra. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.lina;

public class Dimension
{

	int width;
	int height;

	public Dimension(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Dimension)) {
			return false;
		}
		Dimension other = (Dimension) o;
		return other.height == height && other.width == width;
	}

	@Override
	public String toString()
	{
		return height + "x" + width;
	}

}
