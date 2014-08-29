package it.pkg.biz;

import it.pkg.dao.domain.DemoDO;
import archetype.it.tools.web.page.BaseQuery;
import archetype.it.tools.web.page.BizResult;

public interface DemoBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(DemoDO demoDO);

        BizResult update(DemoDO demoDO);

}
