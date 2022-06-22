package com.kohlerpop1.ArmorEffectsMaven.Utils;

import java.util.Map;

public class Pair<K, V>
{
	private K key;
	private V value;

	public Pair(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	public Pair(Map.Entry<K, V> entry)
	{
		this(entry.getKey(), entry.getValue());
	}

	public K getKey()
	{
		return this.key;
	}

	public void setKey(K key)
	{
		this.key = key;
	}

	public V getValue()
	{
		return this.value;
	}
	public void setValue(V value)
	{
		this.value = value;
	}

	public String toString()
	{
		return "Pair=" + key + ":" + value;
	}

	@Override
	public boolean equals(Object pair)
	{
		if (this == pair)
			return true;
		else if (pair instanceof Pair)
			return key != null && value != null && key.equals(((Pair<?, ?>)pair).key) && value.equals(((Pair<?, ?>)pair).value);
		else
			return false;
	}
}
