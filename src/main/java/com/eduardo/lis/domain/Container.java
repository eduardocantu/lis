package com.eduardo.lis.domain;

import com.eduardo.lis.domain.sample.Sample;

import lombok.Data;

@Data
public abstract class Container<T extends Sample> {

	private Patient belongsTo;

	private T sample;

}
