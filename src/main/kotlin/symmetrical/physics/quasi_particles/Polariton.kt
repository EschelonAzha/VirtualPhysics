package symmetrical.physics.quasi_particles

import asymmetrical.physics.machine.config.Config
import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.dictionary.quasiparticles.RemoteId
import symmetrical.physics.atomic.atoms.states.Text
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle


open class Polariton (
    private val matterAntiMatter: IMatter = Matter().with(Polariton::class)
) :
    IMatterAntiMatter by matterAntiMatter,
    IEmitter
{
    private  var key        : QuasiParticle = QuasiParticle()
    private  var value      : QuasiParticle = QuasiParticle()

    constructor(key:String, value:Any?) : this() {
        this.key    = QuasiParticle().with(key)
        this.value  = QuasiParticle().with(value)
    }

    fun getKey() : QuasiParticle {
        return key
    }
    fun getValue() : QuasiParticle {
        return value
    }
    fun setKey(key:String) : Polariton {
        this.key.setContent(key)
        return this
    }
    fun setValue(value:Any?) : Polariton {
        this.value.setContent(value)
        return this
    }
    override fun isIlluminated ()                : Boolean {
        return false
    }
    override fun manifest  ()                    : IEmitter? {
        return this
    }


    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = key.absorb(remainder)
        remainder = value.absorb(remainder)

        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        val classId:String = matterAntiMatter.getClassId()
        val key    :String = key.emit().radiate()
        val value  :String = value.emit().radiate()

        return classId+key+value
    }
    // ########################### EMISSIONS ###########################
}