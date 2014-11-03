package com.bayviewglen.crosscountryassignment;

import java.text.DecimalFormat;

public class CrossCountryTest {

	public static final int MIN_TO_SEC = 60;

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("######.000");
		
		String runner1Split1 = "1:05.3";
		String runner1StartToMile2 = "2:15.4";
		String runner1TotalTime = "5:53.53";

		// Start Split 1 Conversion //

		int runner1Split1colon = runner1Split1.indexOf(':');
		String runner1Split1Min = runner1Split1.substring(0, runner1Split1colon);
		double runner1Split1MinDouble = Double.parseDouble(runner1Split1Min);
		double runner1Split1MinInSec = runner1Split1MinDouble * MIN_TO_SEC;

		int runner1Split1decimal = runner1Split1.indexOf('.');
		String runner1Split1Sec = runner1Split1.substring(runner1Split1colon + 1, runner1Split1decimal);
		double runner1Split1SecDouble = Double.parseDouble(runner1Split1Sec);

		int runner1Split1length = runner1Split1.length();
		String runner1Split1Ms = runner1Split1.substring(runner1Split1decimal, runner1Split1length);
		double runner1Split1MsDouble = Double.parseDouble(runner1Split1Ms);

		double runner1Split1SecAndMs = runner1Split1MinInSec + runner1Split1SecDouble + runner1Split1MsDouble;

		// End Split 1 Conversion //

		// Start Mile 2 Conversion //

		int runner1StartToMile2colon = runner1StartToMile2.indexOf(':');
		String runner1StartToMile2Min = runner1StartToMile2.substring(0, runner1StartToMile2colon);
		double runner1StartToMile2MinDouble = Double.parseDouble(runner1StartToMile2Min);
		double runner1StartToMile2MinInSec = runner1StartToMile2MinDouble * MIN_TO_SEC;

		int runner1StartToMile2decimal = runner1StartToMile2.indexOf('.');
		String runner1StartToMile2Sec = runner1StartToMile2.substring(runner1StartToMile2colon + 1, runner1StartToMile2decimal);
		double runner1StartToMile2SecDouble = Double.parseDouble(runner1StartToMile2Sec);

		int runner1StartToMile2length = runner1StartToMile2.length();
		String runner1StartToMile2Ms = runner1StartToMile2.substring(runner1StartToMile2decimal, runner1StartToMile2length);
		double runner1StartToMile2MsDouble = Double.parseDouble(runner1StartToMile2Ms);

		double runner1StartToMile2SecAndMs = runner1StartToMile2MinInSec + runner1StartToMile2SecDouble + runner1StartToMile2MsDouble;

		// End Mile 2 Conversion //

		// Start Total Time Conversion //

		int runner1TotalTimecolon = runner1TotalTime.indexOf(':');
		String runner1TotalTimeMin = runner1TotalTime.substring(0, runner1TotalTimecolon);
		double runner1TotalTimeMinDouble = Double.parseDouble(runner1TotalTimeMin);
		double runner1TotalTimeMinInSec = runner1TotalTimeMinDouble * MIN_TO_SEC;

		int runner1TotalTimedecimal = runner1TotalTime.indexOf('.');
		String runner1TotalTimeSec = runner1TotalTime.substring(runner1TotalTimecolon + 1, runner1TotalTimedecimal);
		double runner1TotalTimeSecDouble = Double.parseDouble(runner1TotalTimeSec);

		int runner1TotalTimelength = runner1TotalTime.length();
		String runner1TotalTimeMs = runner1TotalTime.substring(runner1TotalTimedecimal, runner1TotalTimelength);
		double runner1TotalTimeMsDouble = Double.parseDouble(runner1TotalTimeMs);

		double runner1TotalTimeSecAndMs = runner1TotalTimeMinInSec + runner1TotalTimeSecDouble + runner1TotalTimeMsDouble;

		System.out.println(runner1TotalTimeSecAndMs);
		System.out.println(runner1StartToMile2SecAndMs);

		// End Total Time Conversion //

		// Start Split 2 Calculations //

		String runner1Split2SecAndMs = formatter.format(runner1StartToMile2SecAndMs - runner1Split1SecAndMs);

		int runner1Split2SecAndMsdecimal = runner1Split2SecAndMs.indexOf(".");
		int runner1Split2SecAndMsLength = runner1Split2SecAndMs.length();

		String runner1Split2Ms = runner1Split2SecAndMs.substring(runner1Split2SecAndMsdecimal, runner1Split2SecAndMsLength);
		String runner1Split2Sec = runner1Split2SecAndMs.substring(0, runner1Split2SecAndMsdecimal);

		int runner1Split2SecDouble = (int) Double.parseDouble(runner1Split2Sec);

		int runner1Split2Min = runner1Split2SecDouble / MIN_TO_SEC;

		int runner1Split2SecFormat = runner1Split2SecDouble - (runner1Split2Min * 60);
		String runner1Split2SecFormatStr = "" + runner1Split2SecFormat;
		String runner1Split2SecFormatTens = "00".substring(runner1Split2SecFormatStr.length()) + runner1Split2SecFormatStr;
		
		String runner1Split2 = runner1Split2Min + ":" + runner1Split2SecFormatTens + runner1Split2Ms;

		System.out.println(runner1Split2);

		// End Split 2 Calculations //

		// Start Split 3 Calculations //

		String runner1Split3SecAndMs = formatter.format(runner1TotalTimeSecAndMs - runner1StartToMile2SecAndMs);

		int runner1Split3SecAndMsdecimal = runner1Split3SecAndMs.indexOf(".");
		int runner1Split3SecAndMsLength = runner1Split3SecAndMs.length();

		String runner1Split3Ms = runner1Split3SecAndMs.substring(runner1Split3SecAndMsdecimal, runner1Split3SecAndMsLength);
		String runner1Split3Sec = runner1Split3SecAndMs.substring(0, runner1Split3SecAndMsdecimal);

		System.out.println(runner1Split3SecAndMs);

		int runner1Split3SecDouble = (int) Double.parseDouble(runner1Split3Sec);

		int runner1Split3Min = runner1Split3SecDouble / MIN_TO_SEC;

		int runner1Split3SecFormat = runner1Split3SecDouble - (runner1Split3Min * 60);

		String runner1Split3 = runner1Split3Min + ":" + runner1Split3SecFormat + runner1Split3Ms;

		System.out.println(runner1Split3);

		// End Split 3 Calculations //

		// Start Split 1 Formatting //
		
		String runner1Split1MinAndSec = runner1Split1.substring(0, runner1Split1decimal);
		String runner1Split1MsFormatted = formatter.format(runner1Split1MsDouble);
		String runner1Split1Formatted = runner1Split1MinAndSec + runner1Split1MsFormatted;
		
		System.out.println(runner1Split1Formatted);
		
		// End Split 1 Formatting //
		
		// Start Total Time Formatting //
		
		String runner1TotalTimeMinAndSec = runner1TotalTime.substring(0, runner1TotalTimedecimal);
		String runner1TotalTimeMsFormatted = formatter.format(runner1TotalTimeMsDouble);
		String runner1TotalTimeFormatted = runner1TotalTimeMinAndSec + runner1TotalTimeMsFormatted;
		
		System.out.println(runner1TotalTimeFormatted);
		
		// End Total Time Formatting //
		
		
		
	}
}
