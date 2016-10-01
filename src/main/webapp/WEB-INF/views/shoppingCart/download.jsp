<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div id="container">
	<div class="content">
		<section class="cartView">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<h2>
						<fmt:message key="h2.startDownload" />
					</h2>
					<p>
						<fmt:message key="p.infoDownload" />
					</p>
				</div>
				<div class="btnCart">
					<a class="link btn btn-default" href=https://s3.amazonaws.com/timetrialgames/Disruption/Disruption.rar>Download </a>
				</div>
			</div>
		</section>
	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
<%@ include file="/WEB-INF/jspf/end.jspf"%>