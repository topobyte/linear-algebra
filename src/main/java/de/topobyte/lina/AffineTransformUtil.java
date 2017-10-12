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

public class AffineTransformUtil
{

	public static Matrix translate(double x, double y)
	{
		Matrix matrix = new Matrix(3, 3);
		matrix.setValue(2, 0, x);
		matrix.setValue(2, 1, y);
		matrix.setValue(0, 0, 1);
		matrix.setValue(1, 1, 1);
		matrix.setValue(2, 2, 1);
		return matrix;
	}

	public static Matrix scale(double x, double y)
	{
		Matrix matrix = new Matrix(3, 3);
		matrix.setValue(0, 0, x);
		matrix.setValue(1, 1, y);
		matrix.setValue(2, 2, 1);
		return matrix;
	}

}
