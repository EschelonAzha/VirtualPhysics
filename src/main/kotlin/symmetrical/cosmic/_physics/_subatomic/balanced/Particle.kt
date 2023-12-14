package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic._physics._dimensions.Dimensions
import symmetrical.cosmic._physics._subatomic.anti_matter.AntiParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import kotlin.reflect.KClass


open class Particle(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Particle::class, AntiParticle::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IParticle,
    Emitter
{
    constructor() : this(
        MatterAntiMatter(Particle::class, AntiParticle::class),
    )
    object Static {
        const val UNIQUE_ID_LENGTH = 1
    }
//    private var uniqueId = ""


    private lateinit var self : IParticle

    private     var uniqueId     :QuantumPhotonicField  = QuantumPhotonicField()
    private     val dimensions   :Dimensions            = Dimensions()
    protected   var fundamentals :Fundamentals          = Fundamentals()


    override fun absorb(photon:Photon) : Photon {
        return uniqueId.absorb(photon)
    }
//    override fun absorb(photon: Photon) : Photon {
//        matterAntiMatter.check(photon);
//
//        val (uniqueId, remainder) = Photons.parse(Static.UNIQUE_ID_LENGTH, photon.propagate().radiate())
//        this.uniqueId = uniqueId
//        return Photon(remainder)
//    }

    override fun emit() : Photon {
        return uniqueId.emit()
    }


//    override fun emit() : Photon {
//        return Photon(radiate())
//    }
//    private fun radiate() : String {
//        val base52Lth = Base52.toFixedBase52(Static.UNIQUE_ID_LENGTH, uniqueId.length)
//        return matterAntiMatter.getClassId()+base52Lth+uniqueId
//    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId.setValue(Keys.getUniqueId())
        return getSelf()
    }


    override fun getIlluminations() : IParticleBeam {
        return matterAntiMatter.getIlluminations()
    }

    override fun getSelf() : IParticle {
        if (::self.isInitialized)
            return self
        else return this
    }

    override fun getUniqueId(): String {
        return uniqueId.getValue() as String
    }

    override fun setSelf(self: IParticle) : IParticle {
        this.self = self
        return getSelf()
    }
    fun setUniqueId(id:String) : IParticle {
        this.uniqueId.setValue(id)
        return getSelf()
    }

    //  FUNDAMENTALS !!!!!!!!!!!!!!!!!!!!!!!
    override fun getValue() : Any? {
        return getWavelength()
    }
    override fun getPhoton() : Photon {
        return fundamentals.getPhoton()
    }
    override fun getMomentum() : AngularMomentum {
        return fundamentals.getAngularMomentum()
    }
    override fun getSpin() : Spin {
        return fundamentals.getSpin()
    }
    override fun getWavelength() : QuantumPhotonicField {
        return fundamentals.getWavelength()
    }
    override fun setSpin(spin: Spin) : IParticle {
        this.fundamentals.setSpin(spin)
        return this
    }
    override fun setMomentum(momentum: AngularMomentum) : IParticle {
        this.fundamentals.setMomentum(momentum)
        return this
    }
    override fun setValue(value:Any?) : IParticle {
        this.setWavelength(value)
        return this
    }
    override fun setWavelength(value:Any?) : IParticle {
        this.getWavelength().setValue(value)
        return this
    }
    override fun momentum() : String {
        if (spin())
            return getMomentum().format(getWavelength())
        else return getWavelength().toString()
    }
    override fun spin() : Boolean {
        return getSpin().isPlus()
    }
    override fun wavelength() : Any? {
        return getWavelength().getValue()
    }
    override fun wavelengthStr() : String {
        val result = wavelength() ?: return ""
        return result.toString()
    }

}