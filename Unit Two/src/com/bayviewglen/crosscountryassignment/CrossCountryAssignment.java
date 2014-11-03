package com.bayviewglen.crosscountryassignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static final int MIN_TO_SEC = 60;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("######.000");

		// Start Runner 1 //

		// Start Name //

		System.out.print("Please enter Runner 1's name: ");
		String runner1Name = keyboard.nextLine();

		int runner1NameSpace = runner1Name.indexOf(' ');
		int runner1NameLength = runner1Name.length();

		String runner1FirstName = runner1Name.substring(0, runner1NameSpace);
		String runner1LastName = runner1Name.substring(runner1NameSpace, runner1NameLength);

		// End Name //

		// Start Times //

		System.out.print("Please enter Runner 1's time from the start of the race to the first mile: ");
		String runner1Split1 = keyboard.nextLine();

		System.out.print("Please enter Runner 1's time from the start of the race to the second mile: ");
		String runner1StartToMile2 = keyboard.nextLine();

		System.out.print("Please enter Runner 1's total time to complete the race: ");
		String runner1TotalTime = keyboard.nextLine();

		// End Times //

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

		// End Split 2 Calculations //

		// Start Split 3 Calculations //

		String runner1Split3SecAndMs = formatter.format(runner1TotalTimeSecAndMs - runner1StartToMile2SecAndMs);

		int runner1Split3SecAndMsdecimal = runner1Split3SecAndMs.indexOf(".");
		int runner1Split3SecAndMsLength = runner1Split3SecAndMs.length();

		String runner1Split3Ms = runner1Split3SecAndMs.substring(runner1Split3SecAndMsdecimal, runner1Split3SecAndMsLength);
		String runner1Split3Sec = runner1Split3SecAndMs.substring(0, runner1Split3SecAndMsdecimal);

		int runner1Split3SecDouble = (int) Double.parseDouble(runner1Split3Sec);

		int runner1Split3Min = runner1Split3SecDouble / MIN_TO_SEC;

		int runner1Split3SecFormat = runner1Split3SecDouble - (runner1Split3Min * 60);
		String runner1Split3SecFormatStr = "" + runner1Split3SecFormat;
		String runner1Split3SecFormatTens = "00".substring(runner1Split3SecFormatStr.length()) + runner1Split3SecFormatStr;
		
		String runner1Split3 = runner1Split3Min + ":" + runner1Split3SecFormatTens + runner1Split3Ms;

		// End Split 3 Calculations //

		// Start Split 1 Formatting //

		String runner1Split1MinAndSec = runner1Split1.substring(0, runner1Split1decimal);
		String runner1Split1MsFormat = formatter.format(runner1Split1MsDouble);
		String runner1Split1Format = runner1Split1MinAndSec + runner1Split1MsFormat;

		// End Split 1 Formatting //

		// Start Total Time Formatting //

		String runner1TotalTimeMinAndSec = runner1TotalTime.substring(0, runner1TotalTimedecimal);
		String runner1TotalTimeMsFormat = formatter.format(runner1TotalTimeMsDouble);
		String runner1TotalTimeFormat = runner1TotalTimeMinAndSec + runner1TotalTimeMsFormat;

		// End Total Time Formatting //

		// Start Summary //

		System.out.println("\nRunner 1 Summary: " + runner1LastName + ", " + runner1FirstName);

		System.out.println("Time for First Split: " + runner1Split1Format);
		System.out.println("Time for Second Split: " + runner1Split2);
		System.out.println("Time for Third Split: " + runner1Split3);
		System.out.println("Total Time: " + runner1TotalTimeFormat);

		// End Summary //

		// End Runner 1 //

		// Start Runner 2 //

		// Start Name //

		System.out.print("\nPlease enter Runner 2's name: ");
		String runner2Name = keyboard.nextLine();

		int runner2NameSpace = runner2Name.indexOf(' ');
		int runner2NameLength = runner2Name.length();

		String runner2FirstName = runner2Name.substring(0, runner2NameSpace);
		String runner2LastName = runner2Name.substring(runner2NameSpace, runner2NameLength);

		// End Name //

		// Start Times //

		System.out.print("Please enter Runner 2's time from the start of the race to the first mile: ");
		String runner2Split1 = keyboard.nextLine();

		System.out.print("Please enter Runner 2's time from the start of the race to the second mile: ");
		String runner2StartToMile2 = keyboard.nextLine();

		System.out.print("Please enter Runner 2's total time to complete the race: ");
		String runner2TotalTime = keyboard.nextLine();

		// End Times //

		// Start Split 1 Conversion //

		int runner2Split1colon = runner2Split1.indexOf(':');
		String runner2Split1Min = runner2Split1.substring(0, runner2Split1colon);
		double runner2Split1MinDouble = Double.parseDouble(runner2Split1Min);
		double runner2Split1MinInSec = runner2Split1MinDouble * MIN_TO_SEC;

		int runner2Split1decimal = runner2Split1.indexOf('.');
		String runner2Split1Sec = runner2Split1.substring(runner2Split1colon + 1, runner2Split1decimal);
		double runner2Split1SecDouble = Double.parseDouble(runner2Split1Sec);

		int runner2Split1length = runner2Split1.length();
		String runner2Split1Ms = runner2Split1.substring(runner2Split1decimal, runner2Split1length);
		double runner2Split1MsDouble = Double.parseDouble(runner2Split1Ms);

		double runner2Split1SecAndMs = runner2Split1MinInSec + runner2Split1SecDouble + runner2Split1MsDouble;

		// End Split 1 Conversion //

		// Start Mile 2 Conversion //

		int runner2StartToMile2colon = runner2StartToMile2.indexOf(':');
		String runner2StartToMile2Min = runner2StartToMile2.substring(0, runner2StartToMile2colon);
		double runner2StartToMile2MinDouble = Double.parseDouble(runner2StartToMile2Min);
		double runner2StartToMile2MinInSec = runner2StartToMile2MinDouble * MIN_TO_SEC;

		int runner2StartToMile2decimal = runner2StartToMile2.indexOf('.');
		String runner2StartToMile2Sec = runner2StartToMile2.substring(runner2StartToMile2colon + 1, runner2StartToMile2decimal);
		double runner2StartToMile2SecDouble = Double.parseDouble(runner2StartToMile2Sec);

		int runner2StartToMile2length = runner2StartToMile2.length();
		String runner2StartToMile2Ms = runner2StartToMile2.substring(runner2StartToMile2decimal, runner2StartToMile2length);
		double runner2StartToMile2MsDouble = Double.parseDouble(runner2StartToMile2Ms);

		double runner2StartToMile2SecAndMs = runner2StartToMile2MinInSec + runner2StartToMile2SecDouble + runner2StartToMile2MsDouble;

		// End Mile 2 Conversion //

		// Start Total Time Conversion //

		int runner2TotalTimecolon = runner2TotalTime.indexOf(':');
		String runner2TotalTimeMin = runner2TotalTime.substring(0, runner2TotalTimecolon);
		double runner2TotalTimeMinDouble = Double.parseDouble(runner2TotalTimeMin);
		double runner2TotalTimeMinInSec = runner2TotalTimeMinDouble * MIN_TO_SEC;

		int runner2TotalTimedecimal = runner2TotalTime.indexOf('.');
		String runner2TotalTimeSec = runner2TotalTime.substring(runner2TotalTimecolon + 1, runner2TotalTimedecimal);
		double runner2TotalTimeSecDouble = Double.parseDouble(runner2TotalTimeSec);

		int runner2TotalTimelength = runner2TotalTime.length();
		String runner2TotalTimeMs = runner2TotalTime.substring(runner2TotalTimedecimal, runner2TotalTimelength);
		double runner2TotalTimeMsDouble = Double.parseDouble(runner2TotalTimeMs);

		double runner2TotalTimeSecAndMs = runner2TotalTimeMinInSec + runner2TotalTimeSecDouble + runner2TotalTimeMsDouble;

		// End Total Time Conversion //

		// Start Split 2 Calculations //

		String runner2Split2SecAndMs = formatter.format(runner2StartToMile2SecAndMs - runner2Split1SecAndMs);

		int runner2Split2SecAndMsdecimal = runner2Split2SecAndMs.indexOf(".");
		int runner2Split2SecAndMsLength = runner2Split2SecAndMs.length();

		String runner2Split2Ms = runner2Split2SecAndMs.substring(runner2Split2SecAndMsdecimal, runner2Split2SecAndMsLength);
		String runner2Split2Sec = runner2Split2SecAndMs.substring(0, runner2Split2SecAndMsdecimal);

		int runner2Split2SecDouble = (int) Double.parseDouble(runner2Split2Sec);

		int runner2Split2Min = runner2Split2SecDouble / MIN_TO_SEC;

		int runner2Split2SecFormat = runner2Split2SecDouble - (runner2Split2Min * 60);
		String runner2Split2SecFormatStr = "" + runner2Split2SecFormat;
		String runner2Split2SecFormatTens = "00".substring(runner2Split2SecFormatStr.length()) + runner2Split2SecFormatStr;
		
		String runner2Split2 = runner2Split2Min + ":" + runner2Split2SecFormatTens + runner2Split2Ms;

		// End Split 2 Calculations //

		// Start Split 3 Calculations //

		String runner2Split3SecAndMs = formatter.format(runner2TotalTimeSecAndMs - runner2StartToMile2SecAndMs);

		int runner2Split3SecAndMsdecimal = runner2Split3SecAndMs.indexOf(".");
		int runner2Split3SecAndMsLength = runner2Split3SecAndMs.length();

		String runner2Split3Ms = runner2Split3SecAndMs.substring(runner2Split3SecAndMsdecimal, runner2Split3SecAndMsLength);
		String runner2Split3Sec = runner2Split3SecAndMs.substring(0, runner2Split3SecAndMsdecimal);

		int runner2Split3SecDouble = (int) Double.parseDouble(runner2Split3Sec);

		int runner2Split3Min = runner2Split3SecDouble / MIN_TO_SEC;

		int runner2Split3SecFormat = runner2Split3SecDouble - (runner2Split3Min * 60);
		String runner2Split3SecFormatStr = "" + runner2Split3SecFormat;
		String runner2Split3SecFormatTens = "00".substring(runner2Split3SecFormatStr.length()) + runner2Split3SecFormatStr;
		
		String runner2Split3 = runner2Split3Min + ":" + runner2Split3SecFormatTens + runner2Split3Ms;

		// End Split 3 Calculations //

		// Start Split 1 Formatting //

		String runner2Split1MinAndSec = runner2Split1.substring(0, runner2Split1decimal);
		String runner2Split1MsFormat = formatter.format(runner2Split1MsDouble);
		String runner2Split1Format = runner2Split1MinAndSec + runner2Split1MsFormat;

		// End Split 1 Formatting //

		// Start Total Time Formatting //

		String runner2TotalTimeMinAndSec = runner2TotalTime.substring(0, runner2TotalTimedecimal);
		String runner2TotalTimeMsFormat = formatter.format(runner2TotalTimeMsDouble);
		String runner2TotalTimeFormat = runner2TotalTimeMinAndSec + runner2TotalTimeMsFormat;

		// End Total Time Formatting //

		// Start Summary //

		System.out.println("\nRunner 2 Summary: " + runner2LastName + ", " + runner2FirstName);

		System.out.println("Time for First Split: " + runner2Split1Format);
		System.out.println("Time for Second Split: " + runner2Split2);
		System.out.println("Time for Third Split: " + runner2Split3);
		System.out.println("Total Time: " + runner2TotalTimeFormat);

		// End Summary //

		// End Runner 2 //

		// Start Runner 3 //

		// Start Name //

		System.out.print("\nPlease enter Runner 3's name: ");
		String runner3Name = keyboard.nextLine();

		int runner3NameSpace = runner3Name.indexOf(' ');
		int runner3NameLength = runner3Name.length();

		String runner3FirstName = runner3Name.substring(0, runner3NameSpace);
		String runner3LastName = runner3Name.substring(runner3NameSpace, runner3NameLength);

		// End Name //

		// Start Times //

		System.out.print("Please enter Runner 3's time from the start of the race to the first mile: ");
		String runner3Split1 = keyboard.nextLine();

		System.out.print("Please enter Runner 3's time from the start of the race to the second mile: ");
		String runner3StartToMile2 = keyboard.nextLine();

		System.out.print("Please enter Runner 3's total time to complete the race: ");
		String runner3TotalTime = keyboard.nextLine();

		// End Times //

		// Start Split 1 Conversion //

		int runner3Split1colon = runner3Split1.indexOf(':');
		String runner3Split1Min = runner3Split1.substring(0, runner3Split1colon);
		double runner3Split1MinDouble = Double.parseDouble(runner3Split1Min);
		double runner3Split1MinInSec = runner3Split1MinDouble * MIN_TO_SEC;

		int runner3Split1decimal = runner3Split1.indexOf('.');
		String runner3Split1Sec = runner3Split1.substring(runner3Split1colon + 1, runner3Split1decimal);
		double runner3Split1SecDouble = Double.parseDouble(runner3Split1Sec);

		int runner3Split1length = runner3Split1.length();
		String runner3Split1Ms = runner3Split1.substring(runner3Split1decimal, runner3Split1length);
		double runner3Split1MsDouble = Double.parseDouble(runner3Split1Ms);

		double runner3Split1SecAndMs = runner3Split1MinInSec + runner3Split1SecDouble + runner3Split1MsDouble;

		// End Split 1 Conversion //

		// Start Mile 2 Conversion //

		int runner3StartToMile2colon = runner3StartToMile2.indexOf(':');
		String runner3StartToMile2Min = runner3StartToMile2.substring(0, runner3StartToMile2colon);
		double runner3StartToMile2MinDouble = Double.parseDouble(runner3StartToMile2Min);
		double runner3StartToMile2MinInSec = runner3StartToMile2MinDouble * MIN_TO_SEC;

		int runner3StartToMile2decimal = runner3StartToMile2.indexOf('.');
		String runner3StartToMile2Sec = runner3StartToMile2.substring(runner3StartToMile2colon + 1, runner3StartToMile2decimal);
		double runner3StartToMile2SecDouble = Double.parseDouble(runner3StartToMile2Sec);

		int runner3StartToMile2length = runner3StartToMile2.length();
		String runner3StartToMile2Ms = runner3StartToMile2.substring(runner3StartToMile2decimal, runner3StartToMile2length);
		double runner3StartToMile2MsDouble = Double.parseDouble(runner3StartToMile2Ms);

		double runner3StartToMile2SecAndMs = runner3StartToMile2MinInSec + runner3StartToMile2SecDouble + runner3StartToMile2MsDouble;

		// End Mile 2 Conversion //

		// Start Total Time Conversion //

		int runner3TotalTimecolon = runner3TotalTime.indexOf(':');
		String runner3TotalTimeMin = runner3TotalTime.substring(0, runner3TotalTimecolon);
		double runner3TotalTimeMinDouble = Double.parseDouble(runner3TotalTimeMin);
		double runner3TotalTimeMinInSec = runner3TotalTimeMinDouble * MIN_TO_SEC;

		int runner3TotalTimedecimal = runner3TotalTime.indexOf('.');
		String runner3TotalTimeSec = runner3TotalTime.substring(runner3TotalTimecolon + 1, runner3TotalTimedecimal);
		double runner3TotalTimeSecDouble = Double.parseDouble(runner3TotalTimeSec);

		int runner3TotalTimelength = runner3TotalTime.length();
		String runner3TotalTimeMs = runner3TotalTime.substring(runner3TotalTimedecimal, runner3TotalTimelength);
		double runner3TotalTimeMsDouble = Double.parseDouble(runner3TotalTimeMs);

		double runner3TotalTimeSecAndMs = runner3TotalTimeMinInSec + runner3TotalTimeSecDouble + runner3TotalTimeMsDouble;

		// End Total Time Conversion //

		// Start Split 2 Calculations //

		String runner3Split2SecAndMs = formatter.format(runner3StartToMile2SecAndMs - runner3Split1SecAndMs);

		int runner3Split2SecAndMsdecimal = runner3Split2SecAndMs.indexOf(".");
		int runner3Split2SecAndMsLength = runner3Split2SecAndMs.length();

		String runner3Split2Ms = runner3Split2SecAndMs.substring(runner3Split2SecAndMsdecimal, runner3Split2SecAndMsLength);
		String runner3Split2Sec = runner3Split2SecAndMs.substring(0, runner3Split2SecAndMsdecimal);

		int runner3Split2SecDouble = (int) Double.parseDouble(runner3Split2Sec);

		int runner3Split2Min = runner3Split2SecDouble / MIN_TO_SEC;

		int runner3Split2SecFormat = runner3Split2SecDouble - (runner3Split2Min * 60);
		String runner3Split2SecFormatStr = "" + runner3Split2SecFormat;
		String runner3Split2SecFormatTens = "00".substring(runner3Split2SecFormatStr.length()) + runner3Split2SecFormatStr;
		
		String runner3Split2 = runner3Split2Min + ":" + runner3Split2SecFormatTens + runner3Split2Ms;

		// End Split 2 Calculations //

		// Start Split 3 Calculations //

		String runner3Split3SecAndMs = formatter.format(runner3TotalTimeSecAndMs - runner3StartToMile2SecAndMs);

		int runner3Split3SecAndMsdecimal = runner3Split3SecAndMs.indexOf(".");
		int runner3Split3SecAndMsLength = runner3Split3SecAndMs.length();

		String runner3Split3Ms = runner3Split3SecAndMs.substring(runner3Split3SecAndMsdecimal, runner3Split3SecAndMsLength);
		String runner3Split3Sec = runner3Split3SecAndMs.substring(0, runner3Split3SecAndMsdecimal);

		int runner3Split3SecDouble = (int) Double.parseDouble(runner3Split3Sec);

		int runner3Split3Min = runner3Split3SecDouble / MIN_TO_SEC;

		int runner3Split3SecFormat = runner3Split3SecDouble - (runner3Split3Min * 60);
		String runner3Split3SecFormatStr = "" + runner3Split3SecFormat;
		String runner3Split3SecFormatTens = "00".substring(runner3Split3SecFormatStr.length()) + runner3Split3SecFormatStr;
		
		String runner3Split3 = runner3Split3Min + ":" + runner3Split3SecFormatTens + runner3Split3Ms;

		// End Split 3 Calculations //

		// Start Split 1 Formatting //

		String runner3Split1MinAndSec = runner3Split1.substring(0, runner3Split1decimal);
		String runner3Split1MsFormat = formatter.format(runner3Split1MsDouble);
		String runner3Split1Format = runner3Split1MinAndSec + runner3Split1MsFormat;

		// End Split 1 Formatting //

		// Start Total Time Formatting //

		String runner3TotalTimeMinAndSec = runner3TotalTime.substring(0, runner3TotalTimedecimal);
		String runner3TotalTimeMsFormat = formatter.format(runner3TotalTimeMsDouble);
		String runner3TotalTimeFormat = runner3TotalTimeMinAndSec + runner3TotalTimeMsFormat;

		// End Total Time Formatting //

		// Start Summary //

		System.out.println("\nRunner 3 Summary: " + runner3LastName + ", " + runner3FirstName);

		System.out.println("Time for First Split: " + runner3Split1Format);
		System.out.println("Time for Second Split: " + runner3Split2);
		System.out.println("Time for Third Split: " + runner3Split3);
		System.out.println("Total Time: " + runner3TotalTimeFormat);

		// End Summary //

		// End Runner 3 //

		// Start Runner 4 //

		// Start Name //

		System.out.print("\nPlease enter Runner 4's name: ");
		String runner4Name = keyboard.nextLine();

		int runner4NameSpace = runner4Name.indexOf(' ');
		int runner4NameLength = runner4Name.length();

		String runner4FirstName = runner4Name.substring(0, runner4NameSpace);
		String runner4LastName = runner4Name.substring(runner4NameSpace, runner4NameLength);

		// End Name //

		// Start Times //

		System.out.print("Please enter Runner 4's time from the start of the race to the first mile: ");
		String runner4Split1 = keyboard.nextLine();

		System.out.print("Please enter Runner 4's time from the start of the race to the second mile: ");
		String runner4StartToMile2 = keyboard.nextLine();

		System.out.print("Please enter Runner 4's total time to complete the race: ");
		String runner4TotalTime = keyboard.nextLine();

		// End Times //

		// Start Split 1 Conversion //

		int runner4Split1colon = runner4Split1.indexOf(':');
		String runner4Split1Min = runner4Split1.substring(0, runner4Split1colon);
		double runner4Split1MinDouble = Double.parseDouble(runner4Split1Min);
		double runner4Split1MinInSec = runner4Split1MinDouble * MIN_TO_SEC;

		int runner4Split1decimal = runner4Split1.indexOf('.');
		String runner4Split1Sec = runner4Split1.substring(runner4Split1colon + 1, runner4Split1decimal);
		double runner4Split1SecDouble = Double.parseDouble(runner4Split1Sec);

		int runner4Split1length = runner4Split1.length();
		String runner4Split1Ms = runner4Split1.substring(runner4Split1decimal, runner4Split1length);
		double runner4Split1MsDouble = Double.parseDouble(runner4Split1Ms);

		double runner4Split1SecAndMs = runner4Split1MinInSec + runner4Split1SecDouble + runner4Split1MsDouble;

		// End Split 1 Conversion //

		// Start Mile 2 Conversion //

		int runner4StartToMile2colon = runner4StartToMile2.indexOf(':');
		String runner4StartToMile2Min = runner4StartToMile2.substring(0, runner4StartToMile2colon);
		double runner4StartToMile2MinDouble = Double.parseDouble(runner4StartToMile2Min);
		double runner4StartToMile2MinInSec = runner4StartToMile2MinDouble * MIN_TO_SEC;

		int runner4StartToMile2decimal = runner4StartToMile2.indexOf('.');
		String runner4StartToMile2Sec = runner4StartToMile2.substring(runner4StartToMile2colon + 1, runner4StartToMile2decimal);
		double runner4StartToMile2SecDouble = Double.parseDouble(runner4StartToMile2Sec);

		int runner4StartToMile2length = runner4StartToMile2.length();
		String runner4StartToMile2Ms = runner4StartToMile2.substring(runner4StartToMile2decimal, runner4StartToMile2length);
		double runner4StartToMile2MsDouble = Double.parseDouble(runner4StartToMile2Ms);

		double runner4StartToMile2SecAndMs = runner4StartToMile2MinInSec + runner4StartToMile2SecDouble + runner4StartToMile2MsDouble;

		// End Mile 2 Conversion //

		// Start Total Time Conversion //

		int runner4TotalTimecolon = runner4TotalTime.indexOf(':');
		String runner4TotalTimeMin = runner4TotalTime.substring(0, runner4TotalTimecolon);
		double runner4TotalTimeMinDouble = Double.parseDouble(runner4TotalTimeMin);
		double runner4TotalTimeMinInSec = runner4TotalTimeMinDouble * MIN_TO_SEC;

		int runner4TotalTimedecimal = runner4TotalTime.indexOf('.');
		String runner4TotalTimeSec = runner4TotalTime.substring(runner4TotalTimecolon + 1, runner4TotalTimedecimal);
		double runner4TotalTimeSecDouble = Double.parseDouble(runner4TotalTimeSec);

		int runner4TotalTimelength = runner4TotalTime.length();
		String runner4TotalTimeMs = runner4TotalTime.substring(runner4TotalTimedecimal, runner4TotalTimelength);
		double runner4TotalTimeMsDouble = Double.parseDouble(runner4TotalTimeMs);

		double runner4TotalTimeSecAndMs = runner4TotalTimeMinInSec + runner4TotalTimeSecDouble + runner4TotalTimeMsDouble;

		// End Total Time Conversion //

		// Start Split 2 Calculations //

		String runner4Split2SecAndMs = formatter.format(runner4StartToMile2SecAndMs - runner4Split1SecAndMs);

		int runner4Split2SecAndMsdecimal = runner4Split2SecAndMs.indexOf(".");
		int runner4Split2SecAndMsLength = runner4Split2SecAndMs.length();

		String runner4Split2Ms = runner4Split2SecAndMs.substring(runner4Split2SecAndMsdecimal, runner4Split2SecAndMsLength);
		String runner4Split2Sec = runner4Split2SecAndMs.substring(0, runner4Split2SecAndMsdecimal);

		int runner4Split2SecDouble = (int) Double.parseDouble(runner4Split2Sec);

		int runner4Split2Min = runner4Split2SecDouble / MIN_TO_SEC;

		int runner4Split2SecFormat = runner4Split2SecDouble - (runner4Split2Min * 60);
		String runner4Split2SecFormatStr = "" + runner4Split2SecFormat;
		String runner4Split2SecFormatTens = "00".substring(runner4Split2SecFormatStr.length()) + runner4Split2SecFormatStr;
		
		String runner4Split2 = runner4Split2Min + ":" + runner4Split2SecFormatTens + runner4Split2Ms;

		// End Split 2 Calculations //

		// Start Split 3 Calculations //

		String runner4Split3SecAndMs = formatter.format(runner4TotalTimeSecAndMs - runner4StartToMile2SecAndMs);

		int runner4Split3SecAndMsdecimal = runner4Split3SecAndMs.indexOf(".");
		int runner4Split3SecAndMsLength = runner4Split3SecAndMs.length();

		String runner4Split3Ms = runner4Split3SecAndMs.substring(runner4Split3SecAndMsdecimal, runner4Split3SecAndMsLength);
		String runner4Split3Sec = runner4Split3SecAndMs.substring(0, runner4Split3SecAndMsdecimal);

		int runner4Split3SecDouble = (int) Double.parseDouble(runner4Split3Sec);

		int runner4Split3Min = runner4Split3SecDouble / MIN_TO_SEC;

		int runner4Split3SecFormat = runner4Split3SecDouble - (runner4Split3Min * 60);
		String runner4Split3SecFormatStr = "" + runner4Split3SecFormat;
		String runner4Split3SecFormatTens = "00".substring(runner4Split3SecFormatStr.length()) + runner4Split3SecFormatStr;
		
		String runner4Split3 = runner4Split3Min + ":" + runner4Split3SecFormatTens + runner4Split3Ms;

		// End Split 3 Calculations //

		// Start Split 1 Formatting //

		String runner4Split1MinAndSec = runner4Split1.substring(0, runner4Split1decimal);
		String runner4Split1MsFormat = formatter.format(runner4Split1MsDouble);
		String runner4Split1Format = runner4Split1MinAndSec + runner4Split1MsFormat;

		// End Split 1 Formatting //

		// Start Total Time Formatting //

		String runner4TotalTimeMinAndSec = runner4TotalTime.substring(0, runner4TotalTimedecimal);
		String runner4TotalTimeMsFormat = formatter.format(runner4TotalTimeMsDouble);
		String runner4TotalTimeFormat = runner4TotalTimeMinAndSec + runner4TotalTimeMsFormat;

		// End Total Time Formatting //

		// Start Summary //

		System.out.println("\nRunner 4 Summary: " + runner4LastName + ", " + runner4FirstName);

		System.out.println("Time for First Split: " + runner4Split1Format);
		System.out.println("Time for Second Split: " + runner4Split2);
		System.out.println("Time for Third Split: " + runner4Split3);
		System.out.println("Total Time: " + runner4TotalTimeFormat);

		// End Summary //

		// End Runner 4 //

		// Start Runner 5 //

		// Start Name //

		System.out.print("\nPlease enter Runner 5's name: ");
		String runner5Name = keyboard.nextLine();

		int runner5NameSpace = runner5Name.indexOf(' ');
		int runner5NameLength = runner5Name.length();

		String runner5FirstName = runner5Name.substring(0, runner5NameSpace);
		String runner5LastName = runner5Name.substring(runner5NameSpace, runner5NameLength);

		// End Name //

		// Start Times //

		System.out.print("Please enter Runner 5's time from the start of the race to the first mile: ");
		String runner5Split1 = keyboard.nextLine();

		System.out.print("Please enter Runner 5's time from the start of the race to the second mile: ");
		String runner5StartToMile2 = keyboard.nextLine();

		System.out.print("Please enter Runner 5's total time to complete the race: ");
		String runner5TotalTime = keyboard.nextLine();

		// End Times //

		// Start Split 1 Conversion //

		int runner5Split1colon = runner5Split1.indexOf(':');
		String runner5Split1Min = runner5Split1.substring(0, runner5Split1colon);
		double runner5Split1MinDouble = Double.parseDouble(runner5Split1Min);
		double runner5Split1MinInSec = runner5Split1MinDouble * MIN_TO_SEC;

		int runner5Split1decimal = runner5Split1.indexOf('.');
		String runner5Split1Sec = runner5Split1.substring(runner5Split1colon + 1, runner5Split1decimal);
		double runner5Split1SecDouble = Double.parseDouble(runner5Split1Sec);

		int runner5Split1length = runner5Split1.length();
		String runner5Split1Ms = runner5Split1.substring(runner5Split1decimal, runner5Split1length);
		double runner5Split1MsDouble = Double.parseDouble(runner5Split1Ms);

		double runner5Split1SecAndMs = runner5Split1MinInSec + runner5Split1SecDouble + runner5Split1MsDouble;

		// End Split 1 Conversion //

		// Start Mile 2 Conversion //

		int runner5StartToMile2colon = runner5StartToMile2.indexOf(':');
		String runner5StartToMile2Min = runner5StartToMile2.substring(0, runner5StartToMile2colon);
		double runner5StartToMile2MinDouble = Double.parseDouble(runner5StartToMile2Min);
		double runner5StartToMile2MinInSec = runner5StartToMile2MinDouble * MIN_TO_SEC;

		int runner5StartToMile2decimal = runner5StartToMile2.indexOf('.');
		String runner5StartToMile2Sec = runner5StartToMile2.substring(runner5StartToMile2colon + 1, runner5StartToMile2decimal);
		double runner5StartToMile2SecDouble = Double.parseDouble(runner5StartToMile2Sec);

		int runner5StartToMile2length = runner5StartToMile2.length();
		String runner5StartToMile2Ms = runner5StartToMile2.substring(runner5StartToMile2decimal, runner5StartToMile2length);
		double runner5StartToMile2MsDouble = Double.parseDouble(runner5StartToMile2Ms);

		double runner5StartToMile2SecAndMs = runner5StartToMile2MinInSec + runner5StartToMile2SecDouble + runner5StartToMile2MsDouble;

		// End Mile 2 Conversion //

		// Start Total Time Conversion //

		int runner5TotalTimecolon = runner5TotalTime.indexOf(':');
		String runner5TotalTimeMin = runner5TotalTime.substring(0, runner5TotalTimecolon);
		double runner5TotalTimeMinDouble = Double.parseDouble(runner5TotalTimeMin);
		double runner5TotalTimeMinInSec = runner5TotalTimeMinDouble * MIN_TO_SEC;

		int runner5TotalTimedecimal = runner5TotalTime.indexOf('.');
		String runner5TotalTimeSec = runner5TotalTime.substring(runner5TotalTimecolon + 1, runner5TotalTimedecimal);
		double runner5TotalTimeSecDouble = Double.parseDouble(runner5TotalTimeSec);

		int runner5TotalTimelength = runner5TotalTime.length();
		String runner5TotalTimeMs = runner5TotalTime.substring(runner5TotalTimedecimal, runner5TotalTimelength);
		double runner5TotalTimeMsDouble = Double.parseDouble(runner5TotalTimeMs);

		double runner5TotalTimeSecAndMs = runner5TotalTimeMinInSec + runner5TotalTimeSecDouble + runner5TotalTimeMsDouble;

		// End Total Time Conversion //

		// Start Split 2 Calculations //

		String runner5Split2SecAndMs = formatter.format(runner5StartToMile2SecAndMs - runner5Split1SecAndMs);

		int runner5Split2SecAndMsdecimal = runner5Split2SecAndMs.indexOf(".");
		int runner5Split2SecAndMsLength = runner5Split2SecAndMs.length();

		String runner5Split2Ms = runner5Split2SecAndMs.substring(runner5Split2SecAndMsdecimal, runner5Split2SecAndMsLength);
		String runner5Split2Sec = runner5Split2SecAndMs.substring(0, runner5Split2SecAndMsdecimal);

		int runner5Split2SecDouble = (int) Double.parseDouble(runner5Split2Sec);

		int runner5Split2Min = runner5Split2SecDouble / MIN_TO_SEC;

		int runner5Split2SecFormat = runner5Split2SecDouble - (runner5Split2Min * 60);
		String runner5Split2SecFormatStr = "" + runner5Split2SecFormat;
		String runner5Split2SecFormatTens = "00".substring(runner5Split2SecFormatStr.length()) + runner5Split2SecFormatStr;
		
		String runner5Split2 = runner5Split2Min + ":" + runner5Split2SecFormatTens + runner5Split2Ms;

		// End Split 2 Calculations //

		// Start Split 3 Calculations //

		String runner5Split3SecAndMs = formatter.format(runner5TotalTimeSecAndMs - runner5StartToMile2SecAndMs);

		int runner5Split3SecAndMsdecimal = runner5Split3SecAndMs.indexOf(".");
		int runner5Split3SecAndMsLength = runner5Split3SecAndMs.length();

		String runner5Split3Ms = runner5Split3SecAndMs.substring(runner5Split3SecAndMsdecimal, runner5Split3SecAndMsLength);
		String runner5Split3Sec = runner5Split3SecAndMs.substring(0, runner5Split3SecAndMsdecimal);

		int runner5Split3SecDouble = (int) Double.parseDouble(runner5Split3Sec);

		int runner5Split3Min = runner5Split3SecDouble / MIN_TO_SEC;

		int runner5Split3SecFormat = runner5Split3SecDouble - (runner5Split3Min * 60);
		String runner5Split3SecFormatStr = "" + runner5Split3SecFormat;
		String runner5Split3SecFormatTens = "00".substring(runner5Split3SecFormatStr.length()) + runner5Split3SecFormatStr;
		
		String runner5Split3 = runner5Split3Min + ":" + runner5Split3SecFormatTens + runner5Split3Ms;

		// End Split 3 Calculations //

		// Start Split 1 Formatting //

		String runner5Split1MinAndSec = runner5Split1.substring(0, runner5Split1decimal);
		String runner5Split1MsFormat = formatter.format(runner5Split1MsDouble);
		String runner5Split1Format = runner5Split1MinAndSec + runner5Split1MsFormat;

		// End Split 1 Formatting //

		// Start Total Time Formatting //

		String runner5TotalTimeMinAndSec = runner5TotalTime.substring(0, runner5TotalTimedecimal);
		String runner5TotalTimeMsFormat = formatter.format(runner5TotalTimeMsDouble);
		String runner5TotalTimeFormat = runner5TotalTimeMinAndSec + runner5TotalTimeMsFormat;

		// End Total Time Formatting //

		// Start Summary //

		System.out.println("\nRunner 5 Summary: " + runner5LastName + ", " + runner5FirstName);

		System.out.println("Time for First Split: " + runner5Split1Format);
		System.out.println("Time for Second Split: " + runner5Split2);
		System.out.println("Time for Third Split: " + runner5Split3);
		System.out.println("Total Time: " + runner5TotalTimeFormat);

		// End Summary //

		// End Runner 5 //

		// Start Table //

		// Start Headings //

		String header1 = "Runner Number:";
		String header2 = "Name:";
		String header3 = "Time for First Split:";
		String header4 = "Time for Second Split:";
		String header5 = "Time for Third Split:";
		String header6 = "Total Time:";

		// End Headings //

		// Start Runner Numbers //

		int runner1 = 1;
		int runner2 = 2;
		int runner3 = 3;
		int runner4 = 4;
		int runner5 = 5;

		// End Runner Numbers //

		System.out.printf("\n\n\n %-24s %-24s %-24s %-24s %-24s %-24s \n", header1, header2, header3, header4, header5, header6);
		System.out.printf("\n %-24s %-24s %-24s %-24s %-24s %-24s", runner1, runner1Name, runner1Split1Format, runner1Split2, runner1Split3, runner1TotalTimeFormat);
		System.out.printf("\n %-24s %-24s %-24s %-24s %-24s %-24s", runner2, runner2Name, runner2Split1Format, runner2Split2, runner2Split3, runner2TotalTimeFormat);
		System.out.printf("\n %-24s %-24s %-24s %-24s %-24s %-24s", runner3, runner3Name, runner3Split1Format, runner3Split2, runner3Split3, runner3TotalTimeFormat);
		System.out.printf("\n %-24s %-24s %-24s %-24s %-24s %-24s", runner4, runner4Name, runner4Split1Format, runner4Split2, runner4Split3, runner4TotalTimeFormat);
		System.out.printf("\n %-24s %-24s %-24s %-24s %-24s %-24s", runner5, runner5Name, runner5Split1Format, runner5Split2, runner5Split3, runner5TotalTimeFormat);

		// End Table //

		keyboard.close();

	}
}