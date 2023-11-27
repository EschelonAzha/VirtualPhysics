package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaMinus
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaPlus
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Baryon(
    private val antiMatter: IAntiMatter = AntiMatter(Baryon::class),
) : Hadron(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Baryon::class),
    )
    init {
        super.i(3)
    }

    object Static {
        const val LAST : Int = Hadron.Static.LAST
    }



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun Proton() : Baryon {
        this.add(Up())    // value
        this.add(Up())    // When Up Points to Neutron
        this.add(Down())  // type
        shrink()
        return this
    }
    fun Neutron() : Baryon {
        this.add(Up())    // value
        this.add(Down())  // When down Points to Proton
        this.add(Down())  // type
        shrink()
        return this
    }

    fun isNeutron() : Boolean {
        return (this.get(1) as Quark) is Down
    }
    fun isProton() : Boolean {
        return (this.get(1) as Quark) is Up
    }

    // Neutron absorbs BetaPlus and becomes Proton
    fun absorb(beta: BetaPlus) : Baryon {

        set(1, Up())

        var up     = get(0) as Up
        var down = get(2) as Down
        up.z(Quark.Args(beta.getPositron().wavelength()))
        down.z(Quark.Args(beta.getNeutrino().wavelength()))

        return this
    }
    // Proton absorbs BetaMinus and becomes Neutron
    fun absorb(beta: BetaMinus) : Baryon {

        set(1, Down())
        val up: Up = get(0) as Up
        up.z(Quark.Args(beta.getElectron().wavelength()))

        beta.getAntiNeutrino()  // points to proton

        return this
    }
    // Turn this Neutron into a Proton
    fun betaMinusDecay() : Pair<Baryon, BetaMinus> {
        var beta        = BetaMinus()
        this.set(1, beta.decay(this))
        return Pair(this, beta)
    }
    // Turn this Proton into a Neutron
    fun betaPlusDecay() : Pair<Baryon, BetaPlus> {
        var beta        = BetaPlus()
        this.set(1, beta.decay(this))
        return Pair(this, beta)
    }
    fun exchange(baryon: Baryon) : Baryon {
        return this
    }
    fun red() : Any? {
        return (this.get(0) as Quark).red()
    }
    fun blue() : String {
        return (this.get(0) as Quark).blue()
    }
    fun green() : String {
        return (this.get(0) as Quark).green()
    }
    fun currentColor() : Any? {
        return (this.get(0) as Quark).currentColor()
    }
    fun setGreen(green: Green) : Baryon {
        (get(0) as Quark).setGreen(green)
        return this
    }
    fun setValue(value:Any?) : Baryon {
        var down: Down = this.get(0) as Down
        //  up.setValue(value)
        down.z(Quark.Args(value))
        return this
    }
    fun setBinding(boundTo: Baryon) : Baryon {
        val up: Quark = this.get(1) as Quark
        (this.get(1) as Quark).z(Quark.Args(boundTo))
        return this
    }
    fun setPurpose(value:Any?) : Baryon {
        var item = this.get(0)
        var down: Down = this.get(0) as Down
        down.z(Quark.Args(value))
        return this
    }
}