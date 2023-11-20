package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Strobe (
    private val fermion: IFermion = Fermion(),

    ) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Strobe::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Strobe {
        return this
    }
    fun frame(timestamp:Double): Unit {
        return
    }
    fun start() : Strobe {
        requestAnimationFrame.start()
        return this
    }
}