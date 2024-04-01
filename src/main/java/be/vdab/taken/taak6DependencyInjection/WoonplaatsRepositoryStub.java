package be.vdab.taken.taak6DependencyInjection;

import java.util.List;

public class WoonplaatsRepositoryStub extends TxtWoonplaatsRepository {
    @Override
    public List<String> findMetStreepjes() {
        return List.of("L-e-u-v-e-n", "H-a-a-cht", "L-ieg-e-", "Antwe-rpe-n");
    }
}
