package symmetrical.cosmic._physics._creation


import asymmetrical.machine.threads.Cores
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class BigBang (
    private val fermion: IFermion = Fermion(BigBang::class),
):
    IFermion by fermion
{
    constructor() : this(
        Fermion(BigBang::class),
    )

    private lateinit var universe       : Universe
    var cores                           : Cores = Cores()

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i(universe: Universe) : BigBang {
        this.universe = universe;
        //  BootConfig.UNIVERSE = universe
        return this;
    }
    fun runUI() : Unit {
        // this starts and runs the browser UI
     //   Application.launch(FxLauncher::class.java)
    }

    fun run() : Unit {
        // this runs a console app
        this.universe.run()
    }

}