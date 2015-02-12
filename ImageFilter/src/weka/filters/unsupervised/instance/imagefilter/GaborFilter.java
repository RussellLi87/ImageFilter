package weka.filters.unsupervised.instance.imagefilter;

import java.awt.image.BufferedImage;

import net.semanticmetadata.lire.imageanalysis.Gabor;

public class GaborFilter extends AbstractImageFilter {

	private static final long serialVersionUID = -7632510789844493778L;
	
	private Gabor features;

	public String globalInfo() {
		return "A batch filter for extracting Gabor texture features from images.";
	}

	public GaborFilter() {
		super();
		features = new Gabor();
	}

	protected int getNumFeatures() {
		//return features.getDoubleHistogram().length;
		return 60; // this is hardcoded due to a null-pointer error in LIRE
		           // if LIRE changes this value then this filter will break
	}

	protected String getFeatureNamePrefix() {
		return features.getFeatureName();
	}

	protected double[] getFeatures(BufferedImage img) {
		features.extract(img);
		return features.getDoubleHistogram();
	}

	public static void main(String[] args) {
		runFilter(new GaborFilter(), args);
	}
	
}
