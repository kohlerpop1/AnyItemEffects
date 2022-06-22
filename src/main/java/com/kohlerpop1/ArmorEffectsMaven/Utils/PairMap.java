package com.kohlerpop1.ArmorEffectsMaven.Utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PairMap<K, V> extends HashMap<K, V>
{
	public PairMap(int i)
	{
		super(i);
	}

	public PairMap()
	{
		super();
	}

	public List<Pair<K, V>> sort(Comparator<Pair<K, V>> comparator)
	{
		return entrySet().stream().map(Pair::new).sorted(comparator).collect(Collectors.toList());
	}

	public V getOrAdd(K key, V value)
	{
		return computeIfAbsent(key, k -> value);
	}
}
