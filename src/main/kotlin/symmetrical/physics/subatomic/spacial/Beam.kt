package symmetrical.physics.subatomic.spacial
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.transpectors.transpectors.Strings
import kotlin.reflect.KClass

// For more information visit:   https://en.wikipedia.org/wiki/Particle_beam


open class Beam() : IBeam {

    private var count                   :Int = 0;
    private lateinit var _memoryBlock   :Array<Any?>
    private var expandMode              :Int = Static.NORMAL

    private var _capacity                :Int = 0
    init {
        capacity(1)
    }

    open fun capacity(capacity:Int=1) : Beam {
        _memoryBlock    = createBlock(capacity)
        this._capacity   = capacity
        return this
    }
    object Static {
        const val NORMAL    : Int = 0
        const val ADD_1     : Int = 1

        const val LAST      : Int = -1
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
        _memoryBlock = createBlock(_capacity)
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
    override fun findByType(classType: KClass<*>) : Int {
        for (i:Int in 0 until count) {
            if (get(i)!!::class==classType) {
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