/*
 * Joda Software License, Version 1.0
 *
 *
 * Copyright (c) 2001-2004 Stephen Colebourne.  
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        Joda project (http://www.joda.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The name "Joda" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact licence@joda.org.
 *
 * 5. Products derived from this software may not be called "Joda",
 *    nor may "Joda" appear in their name, without prior written
 *    permission of the Joda project.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE JODA AUTHORS OR THE PROJECT
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Joda project and was originally 
 * created by Stephen Colebourne <scolebourne@joda.org>. For more
 * information on the Joda project, please see <http://www.joda.org/>.
 */
package org.joda.test.time.partial;

import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.partial.TimeOfDay;

/**
 * This class is a Junit unit test for TimeOfDay.
 *
 * @author Stephen Colebourne
 */
public class TestTimeOfDay extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.getInstance("Europe/Paris");
    
    private long TEST_TIME =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;
            
    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestTimeOfDay.class);
    }

    public TestTimeOfDay(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(DateTimeZone.UTC);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
    }

    //-----------------------------------------------------------------------
    /**
     * Test constructor ()
     */
    public void testConstructor() throws Throwable {
        TimeOfDay test = new TimeOfDay();
        assertEquals(ISOChronology.getInstance(), test.getChronology());
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
    }

    /**
     * Test constructor (Chronology)
     */
    public void testConstructor_Chronology() throws Throwable {
        TimeOfDay test = new TimeOfDay(JulianChronology.getInstance());
        assertEquals(JulianChronology.getInstance(), test.getChronology());
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
    }

    /**
     * Test constructor (long)
     */
    public void testConstructor_long() throws Throwable {
        TimeOfDay test = new TimeOfDay(TEST_TIME);
        assertEquals(ISOChronology.getInstance(), test.getChronology());
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
    }

    /**
     * Test constructor (long, Chronology)
     */
    public void testConstructor_longChronology() throws Throwable {
        TimeOfDay test = new TimeOfDay(TEST_TIME, JulianChronology.getInstance());
        assertEquals(JulianChronology.getInstance(), test.getChronology());
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
    }

    /**
     * Test constructor (Object)
     */
    public void testConstructor_Object() throws Throwable {
        // TODO
    }

    /**
     * Test constructor (Object, Chronology)
     */
    public void testConstructor_ObjectChronology() throws Throwable {
        // TODO
    }

    /**
     * Test constructor (int, int, int, int)
     */
    public void testConstructor_intintintint() throws Throwable {
        TimeOfDay test = new TimeOfDay(10, 20, 30, 40);
        assertEquals(ISOChronology.getInstance(), test.getChronology());
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
    }

    /**
     * Test constructor (int, int, int, int, Chronology)
     */
    public void testConstructor_intintintintChronology() throws Throwable {
        TimeOfDay test = new TimeOfDay(10, 20, 30, 40, JulianChronology.getInstance());
        assertEquals(JulianChronology.getInstance(), test.getChronology());
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
    }

    public void testGetField() {
        TimeOfDay test = new TimeOfDay();
        assertEquals(10, test.get(ISOChronology.getInstance().hourOfDay()));
        assertEquals(20, test.get(ISOChronology.getInstance().minuteOfHour()));
        assertEquals(30, test.get(ISOChronology.getInstance().secondOfMinute()));
        assertEquals(40, test.get(ISOChronology.getInstance().millisOfSecond()));
        try {
            test.get(null);
            fail();
        } catch (IllegalArgumentException ex) {}
        try {
            test.get(ISOChronology.getInstance().dayOfMonth());
            fail();
        } catch (IllegalArgumentException ex) {}
        try {
            test.get(ISOChronology.getInstance(PARIS).hourOfDay());
            fail();
        } catch (IllegalArgumentException ex) {}
        // TODO: Should this fail or suceed - by succeeding it exposes out implementation
//        try {
//            test.get(JulianChronology.getInstance().hourOfDay());
//            fail();
//        } catch (IllegalArgumentException ex) {}
    }

    public void testGetSupportedFields() {
        TimeOfDay test = new TimeOfDay();
        DateTimeField[] fields = test.getSupportedFields();
        assertSame(ISOChronology.getInstance().hourOfDay(), fields[0]);
        assertSame(ISOChronology.getInstance().minuteOfHour(), fields[1]);
        assertSame(ISOChronology.getInstance().secondOfMinute(), fields[2]);
        assertSame(ISOChronology.getInstance().millisOfSecond(), fields[3]);
    }

    public void testIsSupported() {
        TimeOfDay test = new TimeOfDay();
        assertEquals(true, test.isSupported(ISOChronology.getInstance().hourOfDay()));
        assertEquals(true, test.isSupported(ISOChronology.getInstance().minuteOfHour()));
        assertEquals(true, test.isSupported(ISOChronology.getInstance().secondOfMinute()));
        assertEquals(true, test.isSupported(ISOChronology.getInstance().millisOfSecond()));
        assertEquals(false, test.isSupported(ISOChronology.getInstance().dayOfMonth()));
        assertEquals(false, test.isSupported(ISOChronology.getInstance(PARIS).hourOfDay()));
    }

    public void testEqualsHashCode() {
        TimeOfDay test1 = new TimeOfDay(10, 20, 30, 40);
        TimeOfDay test2 = new TimeOfDay(10, 20, 30, 40);
        assertEquals(true, test1.equals(test2));
        assertEquals(true, test2.equals(test1));
        assertEquals(true, test1.equals(test1));
        assertEquals(true, test2.equals(test2));
        assertEquals(test1.hashCode(), test2.hashCode());
        assertEquals(test1.hashCode(), test1.hashCode());
        assertEquals(test2.hashCode(), test2.hashCode());
        
        TimeOfDay test3 = new TimeOfDay(11, 20, 30, 40);
        assertEquals(false, test1.equals(test3));
        assertEquals(false, test2.equals(test3));
        assertEquals(false, test3.equals(test1));
        assertEquals(false, test3.equals(test2));
        assertTrue(test1.hashCode() != test3.hashCode());
        assertTrue(test2.hashCode() != test3.hashCode());
    }

    public void testResolve_long() {
        TimeOfDay test = new TimeOfDay(10, 20, 30, 40);
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
        DateTime dt = new DateTime(0L);
        assertEquals("1970-01-01T00:00:00.000Z", dt.toString());
        
        DateTime result = new DateTime(test.resolve(dt.getMillis(), DateTimeZone.UTC));
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
        assertEquals("1970-01-01T00:00:00.000Z", dt.toString());
        assertEquals("1970-01-01T10:20:30.040Z", result.toString());
    }

    public void testResolve_RI() {
        TimeOfDay test = new TimeOfDay(10, 20, 30, 40);
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
        DateTime dt = new DateTime(0L);
        assertEquals("1970-01-01T00:00:00.000Z", dt.toString());
        
        DateTime result = test.resolveDateTime(dt);
        assertEquals(10, test.getHourOfDay());
        assertEquals(20, test.getMinuteOfHour());
        assertEquals(30, test.getSecondOfMinute());
        assertEquals(40, test.getMillisOfSecond());
        assertEquals("1970-01-01T00:00:00.000Z", dt.toString());
        assertEquals("1970-01-01T10:20:30.040Z", result.toString());
    }

    public void testProperty() {
        TimeOfDay test = new TimeOfDay(10, 20, 30, 40);
        assertSame(test.getChronology().hourOfDay(), test.hourOfDay().getField());
        assertEquals("hourOfDay", test.hourOfDay().getName());
        assertSame(test, test.hourOfDay().getPartialInstant());
        assertSame(test, test.hourOfDay().getTimeOfDay());
        assertEquals(10, test.hourOfDay().get());
        assertEquals("10", test.hourOfDay().getAsText());
        assertEquals("10", test.hourOfDay().getAsText(Locale.FRENCH));
        assertEquals("10", test.hourOfDay().getAsShortText());
        assertEquals("10", test.hourOfDay().getAsShortText(Locale.FRENCH));
        assertEquals(test.getChronology().hours(), test.hourOfDay().getDurationField());
        assertEquals(test.getChronology().days(), test.hourOfDay().getRangeDurationField());
        assertEquals(2, test.hourOfDay().getMaximumTextLength(null));
        assertEquals(2, test.hourOfDay().getMaximumShortTextLength(null));
    }

}