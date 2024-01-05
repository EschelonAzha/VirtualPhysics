package symmetrical.cosmic._physics.subatomic.spacial
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
import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.transpectors.transpectors.Strings
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Particle_beam
 */

open class Beam : IBeam {

    object Static {
        const val NORMAL    : Int = 0
        const val ADD_1     : Int = 1

        const val LAST      : Int = -1
    }

    private var count                   :Int = 0;
    private lateinit var _memoryBlock   :Array<Any?>
    private var expandMode              :Int = Static.NORMAL

    private var capacity                :Int = 0
    constructor(capacity:Int=1)  {
        _memoryBlock    = createBlock(capacity)
        this.capacity   = capacity
    }



    open fun i() : Beam {
        return this
    }

    override fun add(obj:Any?) : Any? {
        if (obj == null)
            return null
        if (isOverflow(count)) {
            expand(expandSizeTo())
        }
        set(count++, obj)
        return obj
    }
    override fun addAll(beam: IBeam) : IBeam {
        for (i in 0 until beam.size()) {
            add(beam.get(i))
        }
        return this
    }
    override fun clear() : IBeam {
        _memoryBlock = createBlock(capacity)
        count = 0
        return this
    }

    override fun compress() : IBeam {
        count = 0
        var result = createBlock(_memoryBlock.size)
        var pos :Int = 0
        for (i in _memoryBlock.indices) {
            if (_memoryBlock[i] == Unit) {
                continue
            }
            if (_memoryBlock[i] != null) {
                result[pos++] = _memoryBlock[i]
                count++
            }
        }
        _memoryBlock = result
        return this
    }

    override fun contract(newSize:Int) : IBeam {
        var result = createBlock(newSize)
        for (i in result.indices) {
            result[i] = _memoryBlock[i]
        }
        _memoryBlock = result
        return this
    }
    override fun expand(size:Int) : IBeam {
        var result = createBlock(size)
        for (i in _memoryBlock.indices) {
            result[i] = _memoryBlock[i]
        }
        _memoryBlock = result
        return this
    }
    override fun find(item:Any) : Int {
        for (i:Int in 0 until count) {
            if (get(i)==item) {
                return i
            }
        }
        return -1
    }
    override fun find(kClass: KClass<*>) : Int {
        for (i:Int in 0 until count) {
            if (get(i)!!::class==kClass) {
                return i
            }
        }
        return -1
    }

    override fun get(pos:Int) : Any? {
        if (isOverflow(pos)) {
            return null
        }
        return _memoryBlock[pos]
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun getCore() : Array<Any?> {
        return _memoryBlock
    }

    override fun isEmpty() : Boolean {
        return count == 0
    }
    override fun isNotEmpty() : Boolean {
        return !isEmpty()
    }
    override fun popLeft() : Any? {
        if (count == 0)
            return null
        val value:Any = _memoryBlock[0] as Any
        _memoryBlock[0] = null
        compress()
        return value
    }

    fun print() : Beam {
        for (i:Int in 0 until count) {
            println(get(i).toString())
        }
        return this
    }

    override fun remove(item:Any) : Any {
        for (i in 0 until count) {
            if (item == get(i)) {
                set(i, null)
            }
        }
        count--
        compress()
        return item
    }
    override fun removeAt(pos:Int) : Any? {
        val item = get(pos)
        if (item == null)
            return item

        return remove(item)
    }
    override fun set(pos:Int, any:Any?) : Any? {
        if (isOverflow(pos))
            expand(pos+1)

        _memoryBlock[pos] = any
        if (pos+1 > count)
            count = pos+1
        return any
    }
    override fun shrink() : IBeam {
        contract(count)
        return this;
    }
    override fun size() : Int {
        return count
    }
    override fun toString() : String {
        return Strings.toDelimitedString("::", _memoryBlock)
    }
    private fun createBlock(size:Int) : Array<Any?> {
        return Array(size){}
    }
    private fun executeExpandMode() : Unit {
        if (expandMode == Static.NORMAL) {
            expand(_memoryBlock.size * 2)
            return
        }

        expand(_memoryBlock.size + 1)
    }
    private fun expandSizeTo() : Int {
        var result:Int = count + 1
        if (expandMode == Static.NORMAL) {
            result = (count+1) * 2
        }
        if (expandMode == Static.ADD_1) {
            result = count + 1
        }
        return result
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Beam::class)
    }

    private fun isOverflow(pos:Int) : Boolean {
        return pos >= _memoryBlock.size
    }

}