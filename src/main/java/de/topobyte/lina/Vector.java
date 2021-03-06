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

import de.topobyte.formatting.DoubleFormatter;

public class Vector extends Matrix
{

	private final VectorType type;

	public Vector(int size, VectorType type)
	{
		super(type == VectorType.Row ? 1 : size,
				type == VectorType.Column ? 1 : size);
		this.type = type;
	}

	public void setValue(int p, double v)
	{
		if (type == VectorType.Column) {
			setValue(0, p, v);
		} else {
			setValue(p, 0, v);
		}
	}

	public double getValue(int p)
	{
		if (type == VectorType.Column) {
			return getValue(0, p);
		} else {
			return getValue(p, 0);
		}
	}

	public int getSize()
	{
		if (type == VectorType.Column) {
			return getHeight();
		} else {
			return getWidth();
		}
	}

	@Override
	public String toString()
	{
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			strb.append(getValue(i));
			if (i < getSize() - 1) {
				strb.append(",");
			}
		}
		return strb.toString();
	}

	public String toString(int k)
	{
		DoubleFormatter formatter = new DoubleFormatter();
		formatter.setFractionDigits(k);

		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			formatter.format(strb, getValue(i));
			if (i < getSize() - 1) {
				strb.append(",");
			}
		}
		return strb.toString();
	}

	public double distance(Vector prev)
	{
		double sum = 0;
		for (int i = 0; i < getSize(); i++) {
			sum += Math.pow(prev.getValue(i) - getValue(i), 2);
		}
		return Math.sqrt(sum);
	}

	public double norm()
	{
		return Math.sqrt(this.transponate().multiplyFromRight(this).toScalar());
	}

	public Vector normalized()
	{
		return this.multiply(1.0 / this.norm()).toVector();
	}

	@Override
	public Vector transponate()
	{
		Vector v = new Vector(getSize(),
				type == VectorType.Column ? VectorType.Row : VectorType.Column);
		for (int i = 0; i < getSize(); i++) {
			v.setValue(i, getValue(i));
		}
		return v;
	}

}
