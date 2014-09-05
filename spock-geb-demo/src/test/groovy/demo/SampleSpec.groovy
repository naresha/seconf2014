package demo

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

/**
 * User: naresha
 * Date: 03/09/14
 * Time: 2:19 AM
 */
@Stepwise
class SampleGebSpec extends GebReportingSpec{

    def "User can login"(){
        when:
            to LoginPage
			login('user1', 'secret')
           
        then:
			at DashboardPage
		and:
			header.pageTitle == 'Dashboard'
    }

	def "Upon search, result page should be shown"(){
		when:
			to DashboardPage
			searchBar.search("my query")
			
		then:
			header.pageTitle == 'Search Result'
	}
}
