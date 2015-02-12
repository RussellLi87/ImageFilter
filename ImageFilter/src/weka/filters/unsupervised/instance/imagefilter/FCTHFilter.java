package weka.filters.unsupervised.instance.imagefilter;

import java.awt.image.BufferedImage;

import net.semanticmetadata.lire.imageanalysis.FCTH;

public class FCTHFilter extends AbstractImageFilter {

	private static final long serialVersionUID = -3726936859958137484L;
	
	private FCTH features;

	public String globalInfo() {
		return "A batch filter for extracting FCTH color features from images.";
	}

	public FCTHFilter() {
		super();
		features = new FCTH();
	}

	protected int getNumFeatures() {
		return features.getDoubleHistogram().length;
	}

	protected String getFeatureNamePrefix() {
		return features.getFeatureName();
	}

	protected double[] getFeatures(BufferedImage img) {
		features.extract(img);
		return features.getDoubleHistogram();
	}

	public static void main(String[] args) {
		runFilter(new FCTHFilter(), args);
	}
	
}
