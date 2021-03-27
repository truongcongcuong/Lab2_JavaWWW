USE [UploadFileServletDB]
GO
/****** Object:  Table [dbo].[contacts]    Script Date: 03/28/2021 04:34:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[contacts](
	[first_name] [nvarchar](100) NULL,
	[last_name] [nvarchar](100) NULL,
	[photo] [varbinary](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
