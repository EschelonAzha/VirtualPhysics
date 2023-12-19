package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic._physics._dimensions.*
import symmetrical.cosmic._physics._subatomic.anti_matter.AntiParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam


open class Particle(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Particle::class, AntiParticle::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IParticle,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(Particle::class, AntiParticle::class),
    ) {
        time.setValue(200)
    }


    private lateinit var self : IParticle

    private     var uniqueId     :QuantumField          = QuantumField()

    private     val time         :Time                  = Time()
    private     val charge       :Charge                = Charge()
    private     val mass         :Mass                  = Mass()
    private     val temperature  :Temperature           = Temperature()
    private     val space        :Space                 = Space()


    private     val dimensions   :Dimensions            = Dimensions()
    protected   var fundamentals :Fundamentals          = Fundamentals()


    override fun absorb(photon:Photon) : Photon {
        var remainder = photon.propagate()
        remainder = uniqueId.absorb(remainder)
        remainder = time.absorb(remainder)
        remainder = charge.absorb(remainder)
        remainder = mass.absorb(remainder)
        remainder = temperature.absorb(remainder)
        remainder = space.absorb(remainder)

        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }


    private fun radiate() : String {
        return getClassId()+
                uniqueId.emit().radiate()+
                time.emit().radiate()+
                charge.emit().radiate()+
                mass.emit().radiate()+
                temperature.emit().radiate()+
                space.emit().radiate()
    }


    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId.setValue(getClassId()+Keys.getUniqueId())
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
    override fun getWavelength() : QuantumField {
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