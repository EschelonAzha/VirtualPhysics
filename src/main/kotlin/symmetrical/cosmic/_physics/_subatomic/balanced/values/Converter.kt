package symmetrical.cosmic._physics._subatomic.balanced.values
/*
                 GNU LESSER GENERAL PUBLIC LICENSE
                      Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.


 This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

 0. Additional Definitions.

 As used herein, “this License” refers to version 3 of the GNU Lesser
General Public License, and the “GNU GPL” refers to version 3 of the GNU
General Public License.

 “The Library” refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

 An “Application” is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

 A “Combined Work” is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the “Linked
Version”.

 The “Minimal Corresponding Source” for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

 The “Corresponding Application Code” for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

 1. Exception to Section 3 of the GNU GPL.

 You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

 2. Conveying Modified Versions.

 If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

  a) under this License, provided that you make a good faith effort to
  ensure that, in the event an Application does not supply the
  function or data, the facility still operates, and performs
  whatever part of its purpose remains meaningful, or

  b) under the GNU GPL, with none of the additional permissions of
  this License applicable to that copy.

 3. Object Code Incorporating Material from Library Header Files.

 The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

  a) Give prominent notice with each copy of the object code that the
  Library is used in it and that the Library and its use are
  covered by this License.

  b) Accompany the object code with a copy of the GNU GPL and this license
  document.

 4. Combined Works.

 You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

  a) Give prominent notice with each copy of the Combined Work that
  the Library is used in it and that the Library and its use are
  covered by this License.

  b) Accompany the Combined Work with a copy of the GNU GPL and this license
  document.

  c) For a Combined Work that displays copyright notices during
  execution, include the copyright notice for the Library among
  these notices, as well as a reference directing the user to the
  copies of the GNU GPL and this license document.

  d) Do one of the following:

      0) Convey the Minimal Corresponding Source under the terms of this
      License, and the Corresponding Application Code in a form
      suitable for, and under terms that permit, the user to
      recombine or relink the Application with a modified version of
      the Linked Version to produce a modified Combined Work, in the
      manner specified by section 6 of the GNU GPL for conveying
      Corresponding Source.

      1) Use a suitable shared library mechanism for linking with the
      Library.  A suitable mechanism is one that (a) uses at run time
      a copy of the Library already present on the user’s computer
      system, and (b) will operate properly with a modified version
      of the Library that is interface-compatible with the Linked
      Version.

  e) Provide Installation Information, but only if you would otherwise
  be required to provide such information under section 6 of the
  GNU GPL, and only to the extent that such information is
  necessary to install and execute a modified version of the
  Combined Work produced by recombining or relinking the
  Application with a modified version of the Linked Version. (If
  you use option 4d0, the Installation Information must accompany
  the Minimal Corresponding Source and Corresponding Application
  Code. If you use option 4d1, you must provide the Installation
  Information in the manner specified by section 6 of the GNU GPL
  for conveying Corresponding Source.)

 5. Combined Libraries.

 You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

  a) Accompany the combined library with a copy of the same work based
  on the Library, uncombined with any other library facilities,
  conveyed under the terms of this License.

  b) Give prominent notice with the combined library that part of it
  is a work based on the Library, and explaining where to find the
  accompanying uncombined form of the same work.

 6. Revised Versions of the GNU Lesser General Public License.

 The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

 Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License “or any later version”
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

 If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy’s public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.
*/
import symmetrical.cosmic._physics._subatomic.balanced.values.booleans.*
import symmetrical.cosmic._physics._subatomic.balanced.values.bytes.*
import symmetrical.cosmic._physics._subatomic.balanced.values.doubles.*
import symmetrical.cosmic._physics._subatomic.balanced.values.ints.*
import symmetrical.cosmic._physics._subatomic.balanced.values.nil.*
import symmetrical.cosmic._physics._subatomic.balanced.values.strings.*
import symmetrical.cosmic._physics._subatomic.balanced.values.vector.*

/*
        const val NULL      = "0"
        const val BOOLEAN   = "B"
        const val BYTE      = "1"
        const val INT       = "I"
        const val DOUBLE    = "D"
        const val STRING1   = "s"
        const val STRING2   = "S"
        const val STRING3   = "!"
        const val VECTOR    = "V"
 */
class Converter {
    val field : Field
    constructor(field:Field) {
        this.field = field
    }

    fun asArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector(field.getContent()).asArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector(field.getContent() as Boolean).asArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector(field.getContent() as Byte).asArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector(field.getContent() as Int).asArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector(field.getContent() as Double).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.VECTOR)
            return VectorVector(field.getContent() as Array<Any>).asArray() as Array<Any>

        println("Converter::asArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun toArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector(field.getContent()).toArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector(field.getContent() as Boolean).toArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector(field.getContent() as Byte).toArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector(field.getContent() as Int).toArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector(field.getContent() as Double).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.VECTOR)
            return VectorVector(field.getContent() as Array<Any>).toArray() as Array<Any>
        println("Converter::toArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun asBoolean() : Boolean? {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean(field.getContent()).asBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean(field.getContent() as Boolean).asBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean(field.getContent() as Byte).asBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean(field.getContent() as Int).asBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean(field.getContent() as Double).asBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.VECTOR)
            return VectorBoolean(field.getContent() as Array<Any>).asBoolean()
        println("Converter::asBoolean:  UnknownType")
        return null
    }

    fun toBoolean() : Boolean {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean(field.getContent()).toBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean(field.getContent() as Boolean).toBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean(field.getContent() as Byte).toBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean(field.getContent() as Int).toBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean(field.getContent() as Double).toBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean(field.getContent() as String).toBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean(field.getContent()as String).toBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean(field.getContent() as String).toBoolean()
        if (field.getType() == Field.Static.VECTOR)
            return VectorBoolean(field.getContent() as Array<Any>).toBoolean()
        println("Converter::toBoolean:  UnknownType")
        return false
    }
    fun asByte() : Byte? {
        if (field.getType() == Field.Static.NULL)
            return NilByte(field.getContent()).asByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte(field.getContent() as Boolean).asByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte(field.getContent() as Byte).asByte()
        if (field.getType() == Field.Static.INT)
            return IntByte(field.getContent() as Int).asByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte(field.getContent() as Double).asByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.VECTOR)
            return VectorByte(field.getContent() as Array<Any>).asByte()
        println("Converter::asByte:  UnknownType")
        return null
    }

    fun toByte() : Byte {
        if (field.getType() == Field.Static.NULL)
            return NilByte(field.getContent()).toByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte(field.getContent() as Boolean).toByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte(field.getContent() as Byte).toByte()
        if (field.getType() == Field.Static.INT)
            return IntByte(field.getContent() as Int).toByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte(field.getContent() as Double).toByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.VECTOR)
            return VectorByte(field.getContent() as Array<Any>).toByte()
        println("Converter::toByte:  UnknownType")
        return 0
    }
    fun asInt() : Int? {
        if (field.getType() == Field.Static.NULL)
            return NilInt(field.getContent()).asInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt(field.getContent() as Boolean).asInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt(field.getContent() as Byte).asInt()
        if (field.getType() == Field.Static.INT)
            return IntInt(field.getContent() as Int).asInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt(field.getContent() as Double).asInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.VECTOR)
            return VectorInt(field.getContent() as Array<Any>).asInt()
        println("Converter::asInt:  UnknownType")
        return null
    }

    fun toInt() : Int {
        if (field.getType() == Field.Static.NULL)
            return NilInt(field.getContent()).toInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt(field.getContent() as Boolean).toInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt(field.getContent() as Byte).toInt()
        if (field.getType() == Field.Static.INT)
            return IntInt(field.getContent() as Int).toInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt(field.getContent() as Double).toInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.VECTOR)
            return VectorInt(field.getContent() as Array<Any>).toInt()
        println("Converter::toInt:  UnknownType")
        return 0
    }
    fun asDouble() : Double? {
        if (field.getType() == Field.Static.NULL)
            return NilDouble(field.getContent()).asDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble(field.getContent() as Boolean).asDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble(field.getContent() as Byte).asDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble(field.getContent() as Int).asDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble(field.getContent() as Double).asDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.VECTOR)
            return VectorDouble(field.getContent() as Array<Any>).asDouble()
        println("Converter::asDouble:  UnknownType")
        return null
    }

    fun toDouble() : Double {
        if (field.getType() == Field.Static.NULL)
            return NilDouble(field.getContent()).toDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble(field.getContent() as Boolean).toDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble(field.getContent() as Byte).toDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble(field.getContent() as Int).toDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble(field.getContent() as Double).toDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.VECTOR)
            return VectorDouble(field.getContent() as Array<Any>).toDouble()
        println("Converter::toDouble:  UnknownType")
        return 0.0
    }

    fun asString() : String? {
        if (field.getType() == Field.Static.NULL)
            return NilString(field.getContent()).asString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString(field.getContent() as Boolean).asString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString(field.getContent() as Byte).asString()
        if (field.getType() == Field.Static.INT)
            return IntString(field.getContent() as Int).asString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString(field.getContent() as Double).asString()
        if (field.getType() == Field.Static.STRING1)
            return StringString(field.getContent() as String).asString()
        if (field.getType() == Field.Static.STRING2)
            return StringString(field.getContent() as String).asString()
        if (field.getType() == Field.Static.STRING3)
            return StringString(field.getContent() as String).asString()
        if (field.getType() == Field.Static.VECTOR)
            return VectorString(field.getContent() as Array<Any>).asString()
        println("Converter::asString:  UnknownType")
        return null
    }

    override fun toString() : String {
        if (field.getType() == Field.Static.NULL)
            return NilString(field.getContent()).toString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString(field.getContent() as Boolean).toString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString(field.getContent() as Byte).toString()
        if (field.getType() == Field.Static.INT)
            return IntString(field.getContent() as Int).toString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString(field.getContent() as Double).toString()
        if (field.getType() == Field.Static.STRING1)
            return StringString(field.getContent() as String).toString()
        if (field.getType() == Field.Static.STRING2)
            return StringString(field.getContent() as String).toString()
        if (field.getType() == Field.Static.STRING3)
            return StringString(field.getContent() as String).toString()
        if (field.getType() == Field.Static.VECTOR)
            return VectorString(field.getContent() as Array<Any>).toString()
        println("Converter::toString:  UnknownType")
        return ""
    }
}