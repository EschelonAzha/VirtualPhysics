package symmetrical.cosmic._physics._subatomic.bosons

import asymmetrical.machine.config.Config
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Photon(
    private val luminescent: ILuminescent = Luminescent(Photon::class),
) : Particle(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Photon::class),
    )
    companion object {
        fun toPhoton(value:Any?, lth:Int=Config.getPhotonLength()) : String {
            if (value == null)
                return Base52.toFixedBase52(lth, 0)
            val str = value.toString()
            val lth = Base52.toFixedBase52(lth, str.length)
            return lth+str
        }
        fun toPhoton1(value:Any?, lth:Int=1) : String {
            if (value == null)
                return Base52.toFixedBase52(lth, 0)
            val str = value.toString()
            val lth = Base52.toFixedBase52(lth, str.length)
            return lth+str
        }
        fun toPhoton2(value:Any?, lth:Int=2) : String {
            if (value == null)
                return Base52.toFixedBase52(lth, 0)
            val str = value.toString()
            val lth = Base52.toFixedBase52(lth, str.length)
            return lth+str
        }
        fun toPhoton3(value:Any?, lth:Int=3) : String {
            if (value == null)
                return Base52.toFixedBase52(lth, 0)
            val str = value.toString()
            val lth = Base52.toFixedBase52(lth, str.length)
            return lth+str
        }


    }

    lateinit    var emitter     : Emitter
                var radiation   : String = ""

    // Spin 1
    constructor(radiation:String) : this() {
        this.radiation = radiation;
        return
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : Photon {
        return this
    }

    fun propagate() : Photon {
        return Photon(Photons.chopClassId(radiation))
    }
    fun radiate() : String {
        return radiation
    }

    fun setEmitter(emitter: Emitter) : Photon {
        this.emitter = emitter
        return this
    }

}