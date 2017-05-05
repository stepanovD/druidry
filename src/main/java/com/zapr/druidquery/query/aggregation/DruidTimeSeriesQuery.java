/*
 * Copyright (c) 2017-present, Red Brick Lane Marketing Solutions Pvt. Ltd.
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.zapr.druidquery.query.aggregation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zapr.druidquery.Context;
import com.zapr.druidquery.Interval;
import com.zapr.druidquery.aggregator.DruidAggregator;
import com.zapr.druidquery.filter.DruidFilter;
import com.zapr.druidquery.granularity.Granularity;
import com.zapr.druidquery.postAggregator.DruidPostAggregator;
import com.zapr.druidquery.query.QueryType;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidTimeSeriesQuery extends DruidAggregationQuery {
    // TODO: String or Boolean??
    private Boolean descending;

    @Builder
    private DruidTimeSeriesQuery(@NonNull String dataSource, Boolean descending,
                                 @NonNull List<Interval> intervals, @NonNull Granularity granularity,
                                 DruidFilter filter, List<DruidAggregator> aggregators,
                                 List<DruidPostAggregator> postAggregators, Context context) {

        this.queryType = QueryType.TIMESERIES;
        this.dataSource = dataSource;
        this.descending = descending;
        this.intervals = intervals;
        this.granularity = granularity;
        this.filter = filter;
        this.aggregations = aggregators;
        this.postAggregations = postAggregators;
        this.context = context;
    }
}
