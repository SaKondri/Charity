function openDialog(xhr, status, args, widgetShow) {
	if ((!args.validationFailed) && (!args.error)) {
		widgetShow.show();
	}
}

function openValidDialog(xhr, status, args, widgetShow1, widgetShow2) {
	if ((!args.validationFailed) && (!args.error)) {
		widgetShow1.show();
	} else {
		widgetShow2.show();
	}
}

function closeDialog(xhr, status, args, widgetHide) {
	if (args.validationFailed || args.error) {
		jQuery('#' + widgetHide.id).effect("shake", {
			times : 2
		}, 100);
	} else {
		widgetHide.hide();
	}
}

function closeAndOpenDialog(xhr, status, args, widgetHide, widgetShow) {
	if (args.validationFailed || args.error) {
		jQuery('#' + widgetHide.id).effect("shake", {
			times : 2
		}, 100);
	} else {
		widgetHide.hide();
		widgetShow.show();
	}
}

function showFatal(xhr, status, args, widgetVar) {
	if (args.fatal) {
		widgetVar.show();
	}
}

function showPopup(url) {
	window
			.open(url, 'ok',
					'height=700,width=1000,scrollbars=yes,resizable=yes');
}