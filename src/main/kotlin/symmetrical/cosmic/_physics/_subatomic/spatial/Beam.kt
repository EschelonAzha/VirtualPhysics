package symmetrical.cosmic._physics._subatomic.spatial

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism


open class Beam : IBeam {

    object Static {
        const val NORMAL    : Int = 0
        const val ADD_1     : Int = 1

        const val LAST      : Int = -1
    }

    private var count      :Int = 0;
    private lateinit var memoryBlock:Array<Any?>
    private var expandMode :Int = Static.NORMAL

    private var capacity   :Int = 0
    constructor(capacity:Int=1)  {
        memoryBlock     = createBlock(capacity)
        this.capacity   = capacity
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Beam::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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
        memoryBlock = createBlock(capacity)
        count = 0
        return this
    }

    override fun compress() : IBeam {
        count = 0
        var result = createBlock(memoryBlock.size)
        var pos :Int = 0
        for (i in memoryBlock.indices) {
            if (memoryBlock[i] == Unit) {
                continue
            }
            if (memoryBlock[i] != null) {
                result[pos++] = memoryBlock[i]
                count++
            }
        }
        memoryBlock = result
        return this
    }

    override fun contract(newSize:Int) : IBeam {
        var result = createBlock(newSize)
        for (i in result.indices) {
            result[i] = memoryBlock[i]
        }
        memoryBlock = result
        return this
    }
    override fun expand(size:Int) : IBeam {
        var result = createBlock(size)
        for (i in memoryBlock.indices) {
            result[i] = memoryBlock[i]
        }
        memoryBlock = result
        return this
    }

    override fun get(pos:Int) : Any? {
        if (isOverflow(pos)) {
            return null
        }
        return memoryBlock[pos]
    }
    override fun getCore() : Array<Any?> {
        return memoryBlock
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
        val value:Any = memoryBlock[0] as Any
        memoryBlock[0] = null
        compress()
        return value
    }

    fun print() : Beam {
        for (i:Int in 0 until count) {
            println(get(i).toString())
        }
        return this
    }
    fun find(item:Any) : Int {
        for (i:Int in 0 until count) {
            if (get(i)==item) {
                return i
            }
        }
        return -1
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

        memoryBlock[pos] = any
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
        return Strings.toDelimitedString("::", memoryBlock)
    }
    private fun createBlock(size:Int) : Array<Any?> {
        return Array(size){}
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

    private fun isOverflow(pos:Int) : Boolean {
        return pos >= memoryBlock.size
    }
    private fun executeExpandMode() : Unit {
        if (expandMode == Static.NORMAL) {
            expand(memoryBlock.size * 2)
            return
        }

        expand(memoryBlock.size + 1)
    }
}