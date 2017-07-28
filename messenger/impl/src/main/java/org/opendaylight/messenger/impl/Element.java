/*
 * Copyright © 2016 me and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.messenger.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Element {

	private Number atomicNumber;
	private String element;
	private String Symbol;
	private Number atomicWeight;
	private Number period;
	private Number group;
	private String phase;
	private String mostStableCrystal;
	private String type;
	private Number ionicRadius;
	private Number atomicRadius;
	private Number electronegativity;
	private Number firstIonizationPotential;
	private Number density;
	private Number meltingPoint;
	private Number boilingPoint;
	private Number isoTopes;
	private String discoverer;
	private Number yearOfDiscovery;
	private Number specificHeatCapacity;
	private String electronConfiguration;
	private Number displayRow;
	private Number displayColumn;

	public String getElement() {
		return element;
	}

	public void setElement(String elementName) {
		this.element = elementName;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public Number getAtomicWeight() {
		return atomicWeight;
	}

	public void setAtomicWeight(Number atomicWeight) {
		this.atomicWeight = atomicWeight;
	}

	public Number getPeriod() {
		return period;
	}

	public void setPeriod(Number period) {
		this.period = period;
	}

	public Number getGroup() {
		return group;
	}

	public void setGroup(Number group) {
		this.group = group;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getMostStableCrystal() {
		return mostStableCrystal;
	}

	public void setMostStableCrystal(String mostStable) {
		this.mostStableCrystal = mostStable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Number getAtomicRadius() {
		return atomicRadius;
	}

	public void setAtomicRadius(Number atomicRadius) {
		this.atomicRadius = atomicRadius;
	}

	public Number getElectronegativity() {
		return electronegativity;
	}

	public void setElectronegativity(Number electronegativity) {
		this.electronegativity = electronegativity;
	}

	public Number getFirstIonizationPotential() {
		return firstIonizationPotential;
	}

	public void setFirstIonizationPotential(Number firstIonizationPotential) {
		this.firstIonizationPotential = firstIonizationPotential;
	}

	public Number getDensity() {
		return density;
	}

	public void setDensity(Number density) {
		this.density = density;
	}

	public Number getMeltingPoint() {
		return meltingPoint;
	}

	public void setMeltingPoint(Number meltingPoint) {
		this.meltingPoint = meltingPoint;
	}

	public Number getBoilingPoint() {
		return boilingPoint;
	}

	public void setBoilingPoint(Number boilingPoint) {
		this.boilingPoint = boilingPoint;
	}

	public Number getIsoTopes() {
		return isoTopes;
	}

	public void setIsoTopes(Number isoTopes) {
		this.isoTopes = isoTopes;
	}

	public String getDiscoverer() {
		return discoverer;
	}

	public void setDiscoverer(String discoverer) {
		this.discoverer = discoverer;
	}

	public Number getYearOfDiscovery() {
		return yearOfDiscovery;
	}

	public void setYearOfDiscovery(Number yearOfDiscovery) {
		this.yearOfDiscovery = yearOfDiscovery;
	}

	public Number getSpecificHeatCapacity() {
		return specificHeatCapacity;
	}

	public void setSpecificHeatCapacity(Number specificHeatCapacity) {
		this.specificHeatCapacity = specificHeatCapacity;
	}

	public String getElectronConfiguration() {
		return electronConfiguration;
	}

	public void setElectronConfiguration(String electronConfiguration) {
		this.electronConfiguration = electronConfiguration;
	}

	public Number getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(Number displayRow) {
		this.displayRow = displayRow;
	}

	public Number getDisplayColumn() {
		return displayColumn;
	}

	public void setDisplayColumn(Number displayColumn) {
		this.displayColumn = displayColumn;
	}

	public Number getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(Number atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public Number getIonicRadius() {
		return ionicRadius;
	}

	public void setIonicRadius(Number ionicRadius) {
		this.ionicRadius = ionicRadius;
	}

}
