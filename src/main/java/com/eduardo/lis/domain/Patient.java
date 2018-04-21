package com.eduardo.lis.domain;

import java.util.List;

import com.eduardo.lis.domain.sample.Sample;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Patient {

	private String name;

	List<Sample> samples;

	Container<?> containers;
}
