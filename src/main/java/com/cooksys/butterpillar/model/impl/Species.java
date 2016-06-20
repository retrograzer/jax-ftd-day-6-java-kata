package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies {
	
	private String name;
	private IGrowthModel growthModel;
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public IGrowthModel getGrowthModel() {
		return growthModel;
	}

	@Override
	public void setGrowthModel(IGrowthModel growthModel) {
		this.growthModel = growthModel;
	}

	@Override
	public ICatterfly createCatterfly(double wingspan, double weight) {
		return new Catterfly(wingspan, weight);
	}

	@Override
	public IButterpillar createButterpillar(double length, double leavesEaten) {
		return new Butterpillar(length, leavesEaten);
	}

	@Override
	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly[] catter = new Catterfly[butterpillars.length];
		for (int i = 0; i < butterpillars.length; i++) {
			catter[i] = growthModel.butterpillarToCatterfly(butterpillars[i]);
		}
		return catter;
	}

	@Override
	public IButterpillar[] convert(ICatterfly[] catterflies) {
		IButterpillar[] butter = new Butterpillar[catterflies.length];
		for (int i = 0; i < catterflies.length; i++) {
			butter[i] = growthModel.catterflyToButterpillar(catterflies[i]);
		}
		return butter;
	}

}
